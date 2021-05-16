package com.bluecyan.pojo;

//首页
public class Home {
    private Integer homeId;

    private String navigationLeft;

    private String navigationBar;

    private String sideshow;

    private String recommend;

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getNavigationLeft() {
        return navigationLeft;
    }

    public void setNavigationLeft(String navigationLeft) {
        this.navigationLeft = navigationLeft == null ? null : navigationLeft.trim();
    }

    public String getNavigationBar() {
        return navigationBar;
    }

    public void setNavigationBar(String navigationBar) {
        this.navigationBar = navigationBar == null ? null : navigationBar.trim();
    }

    public String getSideshow() {
        return sideshow;
    }

    public void setSideshow(String sideshow) {
        this.sideshow = sideshow == null ? null : sideshow.trim();
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend == null ? null : recommend.trim();
    }
}