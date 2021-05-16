package com.bluecyan.service.impl;

import com.bluecyan.mapper.ClothingExtendMapper;
import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.ClothingExample;
import com.bluecyan.pojo.ClothingWithList;
import com.bluecyan.pojo.SearchCondition;
import com.bluecyan.service.BrandService;
import com.bluecyan.service.CategoryService;
import com.bluecyan.service.ClothingService;
import com.bluecyan.service.StyleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 19:24
 * @Description
 **/

@Service
public class ClothingServiceImpl implements ClothingService {

    @Autowired
    ClothingExtendMapper clothingExtendMapper;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StyleService styleService;

    @Override
    public Clothing getClothing(String clothingId) {
        // getAll 带有级联
        return clothingExtendMapper.getAll(clothingId);
    }

    @Override
    public List<Clothing> getClothingList(String clothingIdList) {
        String[] clothingIdArray = clothingIdList.split(",");
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();

        /*调用Arrays.asList()时，其返回值类型是ArrayList，但此ArrayList是Array的内部类，
        调用add()时，会报错：java.lang.UnsupportedOperationException，
        并且结果会因为array的某个值的改变而改变，故需要再次构造一个新的ArrayList。*/
        criteria.andClothingIdIn(new ArrayList<>(Arrays.asList(clothingIdArray)));
        return clothingExtendMapper.selectByExample(clothingExample);
    }


    @Override
    public ClothingWithList getClothingWithList(String clothingId) {
        ClothingWithList clothingWithList = new ClothingWithList();
        clothingWithList.setClothing(getClothing(clothingId));
        return clothingWithList;
    }

    @Override
    public List<ClothingWithList> getClothingWithLists(String clothingIdList) {
        String[] clothingIdArray = clothingIdList.split(",");
        ClothingExample clothingExample = new ClothingExample();
        ClothingExample.Criteria criteria = clothingExample.createCriteria();

        /*调用Arrays.asList()时，其返回值类型是ArrayList，但此ArrayList是Array的内部类，
        调用add()时，会报错：java.lang.UnsupportedOperationException，
        并且结果会因为array的某个值的改变而改变，故需要再次构造一个新的ArrayList。*/
        criteria.andClothingIdIn(new ArrayList<>(Arrays.asList(clothingIdArray)));
        List<Clothing> clothingList = clothingExtendMapper.selectByExample(clothingExample);
        return clothingListToClothingWithLists(clothingList);
    }

    @Override
    public List<ClothingWithList> clothingListToClothingWithLists(List<Clothing> clothingList) {
        List<ClothingWithList> clothingWithLists = new ArrayList<ClothingWithList>();
        for (int i = 0; i < clothingList.size(); i++) {
            ClothingWithList clothingWithList = new ClothingWithList();
            clothingWithList.setClothing(clothingList.get(i));
            clothingWithLists.add(clothingWithList);
        }
        return clothingWithLists;
    }

    @Override
    public List<ClothingWithList> getHotClothingWithLists() {
        ClothingExample clothingExample = new ClothingExample();
        clothingExample.setOrderByClause("sales DESC");
        PageHelper.startPage(1,10);
        return clothingListToClothingWithLists(clothingExtendMapper.selectByExample(clothingExample));
    }

    @Override
    public List<ClothingWithList> getNewClothingWithLists() {
        ClothingExample clothingExample = new ClothingExample();
        clothingExample.setOrderByClause("clothing_id DESC");
        PageHelper.startPage(1,10);
        return clothingListToClothingWithLists(clothingExtendMapper.selectByExample(clothingExample));
    }

    @Override
    public List<ClothingWithList> getClothingWithListsBySearch(SearchCondition searchCondition) {
        return clothingListToClothingWithLists(clothingExtendMapper.getClothingListBySearch(searchCondition));
    }

    @Override
    public PageInfo getClothingListBySearch(SearchCondition searchCondition, int pageSize, int navigatePages) {
        PageHelper.startPage(searchCondition.getPageNum(), pageSize);

        // PageInfo 只能封装 mapper 返回的原装数据 封装转换后的ClothingWithList数据 无法获得分页信息
        // List<ClothingWithList> clothingWithListsBySearch = clothingListToClothingWithLists(clothingExtendMapper.getClothingListBySearch(searchCondition));
        List<Clothing> clothingListBySearch = clothingExtendMapper.getClothingListBySearch(searchCondition);

        // navigatePages: 分页导航显示的 navigatePages 页的页码
        PageInfo clothingListBySearchPageInfo = new PageInfo(clothingListBySearch,navigatePages);
        return clothingListBySearchPageInfo;
    }
}
