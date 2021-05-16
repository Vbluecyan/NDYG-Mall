package com.bluecyan.service;

import com.bluecyan.pojo.Brand;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 20:58
 * @Description
 **/
public interface BrandService {

    List<Brand> getBrandList();

    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 13:53
     * @Description 通过 BrandName 的 like 字符串模糊查询 Brand 并返回对应的 BrandId List
     * @Param [brandNameLike]
     * @Return java.util.List<java.lang.Integer>
     **/
    List<Integer> getBrandIdListByBrandNameLike(String brandNameLike);
}
