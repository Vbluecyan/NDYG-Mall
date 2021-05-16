package com.bluecyan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 12:06
 * @Description
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class HomeServiceTest {

    @Autowired
    HomeService homeService;

//    @Test
//    public void getHomeWithList() {
//        HomeWithList homeWithList = homeService.getHomeWithList(1);
//
//        for (String s : homeWithList.getNavigationLeft()) {
//            System.out.println(s);
//        }
//        System.out.println();
//        for (String s : homeWithList.getNavigationBar()) {
//            System.out.println(s);
//        }
//        System.out.println();
//        for (String s : homeWithList.getSideshow()) {
//            System.out.println(s);
//        }
//        System.out.println();
//        for (Clothing clothing : homeWithList.getRecommendList()) {
//            System.out.println(clothing.getClothingId());
//            System.out.println(clothing.getInventory());
//            System.out.println(clothing.getPrice());
//            System.out.println(clothing.getSex());
//            System.out.println(clothing.getSales());
//            System.out.println("===============================");
//        }
//    }

    @Test
    public void test() {
        String s = "lf//sj/,lsdjfls ,sjdlf ,";
        String[] strings = s.split(" ,");
        for (String string : strings) {
            System.out.println(string);
        }
    }
}