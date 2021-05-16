package com.bluecyan.service;

import com.bluecyan.pojo.Style;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 21:04
 * @Description
 **/
public interface StyleService {

    List<Style> getStyleList();

    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 13:53
     * @Description 通过 StyleName 的 like 字符串模糊查询 Style 并返回对应的 StyleId List
     * @Param [brandNameLike]
     * @Return java.util.List<java.lang.Integer>
     **/
    List<Integer> getStyleIdListByStyleNameLike(String styleNameLike);
}
