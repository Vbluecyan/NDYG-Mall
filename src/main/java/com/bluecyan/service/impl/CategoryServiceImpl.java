package com.bluecyan.service.impl;

import com.bluecyan.mapper.CategoryExtendMapper;
import com.bluecyan.pojo.Category;
import com.bluecyan.pojo.CategoryExample;
import com.bluecyan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 21:03
 * @Description
 **/

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryExtendMapper categoryExtendMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryExtendMapper.selectByExample(null);
    }

    @Override
    public List<Integer> getCategoryIdListByCategoryNameLike(String categoryNameLike) {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andCategoryNameLike("%" + categoryNameLike + "%");
        List<Category> categorys = categoryExtendMapper.selectByExample(categoryExample);
        List<Integer> list = new ArrayList<Integer>();
        for (Category category : categorys) {
            list.add(category.getCategoryId());
        }
        return list;
    }
}
