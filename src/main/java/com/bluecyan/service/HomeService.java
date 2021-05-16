package com.bluecyan.service;

import com.bluecyan.pojo.HomeWithList;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 11:14
 * @Description
 **/
public interface HomeService {

    /**
     * @Author bluecyan
     * @DateTime 2021/4/20 19:30
     * @Description 获取用于预定展示的首页数据
     * @Param [homeId]
     * @Return com.bluecyan.pojo.HomeWithList
     **/
    HomeWithList getHomeWithList(int homeId);
}
