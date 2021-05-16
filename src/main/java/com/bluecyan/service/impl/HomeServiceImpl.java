package com.bluecyan.service.impl;

import com.bluecyan.mapper.HomeExtendMapper;
import com.bluecyan.pojo.HomeWithList;
import com.bluecyan.service.ClothingService;
import com.bluecyan.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 11:23
 * @Description
 **/

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    HomeExtendMapper homeExtendMapper;

    @Autowired
    ClothingService clothingService;

    @Override
    public HomeWithList getHomeWithList(int homeId) {
        HomeWithList homeWithList = new HomeWithList();
        homeWithList.setHome(homeExtendMapper.selectByPrimaryKey(homeId));
        homeWithList.setRecommendList(clothingService.getClothingWithLists(homeWithList.getHome().getRecommend()));
        return homeWithList;
    }
}
