package com.bluecyan.pojo;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 11:31
 * @Description 将从数据库表home中取出的拼接字符串封装成 数组，列表 型数据
 **/
public class HomeWithList {

    private Home home;

    private String[] navigationLeft;

    private String[]  navigationBar;

    private String[]  sideshow;

    private List<ClothingWithList> recommendList;

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
        navigationLeft = home.getNavigationLeft().split(",");
        navigationBar = home.getNavigationBar().split(",");
        sideshow = home.getSideshow().split(",");
    }

    public String[] getNavigationLeft() {
        return navigationLeft;
    }

    public String[] getNavigationBar() {
        return navigationBar;
    }

    public String[] getSideshow() {
        return sideshow;
    }

    public List<ClothingWithList> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<ClothingWithList> recommendList) {
        this.recommendList = recommendList;
    }
}
