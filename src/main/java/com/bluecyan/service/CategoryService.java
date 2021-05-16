package com.bluecyan.service;

import com.bluecyan.pojo.Category;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 21:02
 * @Description
 **/
public interface CategoryService {

    List<Category> getCategoryList();

    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 13:53
     * @Description 通过 CategoryName 的 like 字符串模糊查询 Category 并返回对应的 CategoryId List
     * @Param [brandNameLike]
     * @Return java.util.List<java.lang.Integer>
     **/
    List<Integer> getCategoryIdListByCategoryNameLike(String categoryNameLike);
}
