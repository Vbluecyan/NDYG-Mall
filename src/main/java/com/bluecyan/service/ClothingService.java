package com.bluecyan.service;

import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.ClothingWithList;
import com.bluecyan.pojo.SearchCondition;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 19:24
 * @Description
 **/
public interface ClothingService {

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 14:41
     * @Description 根据clothingId查询对应clothing，带有级联
     * @Param [clothingId]
     * @Return com.bluecyan.pojo.Clothing
     **/
    Clothing getClothing(String clothingId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 0:09
     * @Description 根据clothingId清单字符串，查询清单上所有clothing并以list形式返回
     * @Param [clothingIdList]
     * @Return java.util.List<com.bluecyan.pojo.Clothing>
     **/
    List<Clothing> getClothingList(String clothingIdList);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 14:42
     * @Description 根据clothingId查询对应clothingWithList，带有级联
     * @Param [clothingId]
     * @Return com.bluecyan.pojo.ClothingWithList
     **/
    ClothingWithList getClothingWithList(String clothingId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 14:42
     * @Description 根据 clothingId清单 查询对应 clothingWithList清单
     * @Param [clothingIdList]
     * @Return java.util.List<com.bluecyan.pojo.ClothingWithList>
     **/
    List<ClothingWithList> getClothingWithLists(String clothingIdList);


    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 19:27
     * @Description 将从数据库中查询出的 List<Clothing> 转换为 List<ClothingWithList>
     * @Param [clothingList]
     * @Return java.util.List<com.bluecyan.pojo.ClothingWithList>
     **/
    List<ClothingWithList> clothingListToClothingWithLists(List<Clothing> clothingList);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 19:27
     * @Description 获取月销量最高的10件服装
     * @Param []
     * @Return java.util.List<com.bluecyan.pojo.ClothingWithList>
     **/
    List<ClothingWithList> getHotClothingWithLists();

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 19:28
     * @Description 获取最新上架的10件服装
     * @Param []
     * @Return java.util.List<com.bluecyan.pojo.ClothingWithList>
     **/
    List<ClothingWithList> getNewClothingWithLists();

    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 13:29
     * @Description 根据 搜索条件 查询对应 clothingWithList清单
     * @Param [searchCondition]
     * @Return java.util.List<com.bluecyan.pojo.ClothingWithList>
     **/
    List<ClothingWithList> getClothingWithListsBySearch(SearchCondition searchCondition);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/24 0:03
     * @Description 带有分页功能; 根据 搜索条件 查询对应 clothing 清单
     * @Param [searchCondition]
     * @Return PageInfo
     **/
    PageInfo getClothingListBySearch(SearchCondition searchCondition, int pageSize, int navigatePages);
}
