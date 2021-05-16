package com.bluecyan.service;

import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.ClothingWithList;
import com.bluecyan.pojo.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 23:47
 * @Description
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ClothingServiceTest {

    @Autowired
    ClothingService clothingService;

    @Test
    public void getClothingList() {
        String recommend = "1618765923003,1618765925435,1618765926444,1618765926900,1618765927788,1618765928011,1618765928635,1618765929027,1618765929611,1618765930315,1618765929811,1618765930411,";
        List<Clothing> clothingList = clothingService.getClothingList(recommend);
        for (Clothing clothing : clothingList) {
            System.out.println(clothing.getClothingId());
            System.out.println(clothing.getInventory());
            System.out.println(clothing.getPrice());
            System.out.println(clothing.getSex());
            System.out.println(clothing.getSales());
            System.out.println("===============================");
        }
    }

    @Test
    public void getClothing() {
        String str = "1618765923003";
        Clothing clothing = clothingService.getClothing(str);

        System.out.println("===============================");
        System.out.println(clothing.getClothingId());
        System.out.println(clothing.getInventory());
        System.out.println(clothing.getPrice());
        System.out.println(clothing.getSex());
        System.out.println(clothing.getSales());
        System.out.println(clothing.getPicture());
        System.out.println("===============================");
    }

    @Test
    public void getClothingWithList() {
        String str = "1618765923003";
        ClothingWithList clothingWithList = clothingService.getClothingWithList(str);

        System.out.println("===============================");
        System.out.println(clothingWithList.getClothing().getClothingId());
        System.out.println(clothingWithList.getClothing().getInventory());
        System.out.println(clothingWithList.getClothing().getPrice());
        System.out.println(clothingWithList.getClothing().getSex());
        System.out.println(clothingWithList.getClothing().getSales());
        for (String s : clothingWithList.getPicture()) {
            System.out.println(s);
        }
        System.out.println("===============================");
    }

    @Test
    public void getClothingWithListList() {
        String recommend = "1618765923003,1618765925435,1618765926444,1618765926900,1618765927788,1618765928011,1618765928635,1618765929027,1618765929611,1618765930315,1618765929811,1618765930411,";
        List<ClothingWithList> clothingWithListList = clothingService.getClothingWithLists(recommend);
        for (ClothingWithList clothingWithList : clothingWithListList) {
            System.out.println(clothingWithList.getClothing().getClothingId());
            System.out.println(clothingWithList.getClothing().getInventory());
            System.out.println(clothingWithList.getClothing().getPrice());
            System.out.println(clothingWithList.getClothing().getSex());
            System.out.println(clothingWithList.getClothing().getSales());
            for (String s : clothingWithList.getPicture()) {
                System.out.println(s);
            }
            System.out.println("===============================");
        }
    }

    @Test
    public void getHotClothingWithLists() {
        List<ClothingWithList> clothingWithListList = clothingService.getHotClothingWithLists();
        for (ClothingWithList clothingWithList : clothingWithListList) {
            System.out.println(clothingWithList.getClothing().getClothingId());
            System.out.println(clothingWithList.getClothing().getInventory());
            System.out.println(clothingWithList.getClothing().getPrice());
            System.out.println(clothingWithList.getClothing().getSex());
            System.out.println(clothingWithList.getClothing().getSales());
            for (String s : clothingWithList.getPicture()) {
                System.out.println(s);
            }
            System.out.println("===============================");
        }
    }

    @Test
    public void getNewClothingWithLists() {
        List<ClothingWithList> clothingWithListList = clothingService.getNewClothingWithLists();
        for (ClothingWithList clothingWithList : clothingWithListList) {
            System.out.println(clothingWithList.getClothing().getClothingId());
            System.out.println(clothingWithList.getClothing().getInventory());
            System.out.println(clothingWithList.getClothing().getPrice());
            System.out.println(clothingWithList.getClothing().getSex());
            System.out.println(clothingWithList.getClothing().getSales());
            for (String s : clothingWithList.getPicture()) {
                System.out.println(s);
            }
            System.out.println("===============================");
        }
    }

    @Test
    public void getClothingWithListsBySearch() {
        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setKeyword("2021");
//        searchCondition.setBrands(new int[]{1,2});
//        searchCondition.setCategorys(new int[]{2,3});
//        searchCondition.setStyles(new int[]{1,3,4,9});
        searchCondition.setSexs(new String[] {"女"});
//        searchCondition.setSizes("A|XXL");
        searchCondition.setOrder("sales DESC");


        List<ClothingWithList> clothingWithListList = clothingService.getClothingWithListsBySearch(searchCondition);
        for (ClothingWithList clothingWithList : clothingWithListList) {
            System.out.println(clothingWithList.getClothing().getClothingId());
            System.out.println(clothingWithList.getClothing().getInventory());
            System.out.println(clothingWithList.getClothing().getPrice());
            System.out.println(clothingWithList.getClothing().getBrandId());
            System.out.println(clothingWithList.getClothing().getCategoryId());
            System.out.println(clothingWithList.getClothing().getStyleId());
            System.out.println(clothingWithList.getClothing().getSex());
            System.out.println(clothingWithList.getClothing().getSales());

            for (String s : clothingWithList.getPicture()) {
                System.out.println(s);
            }
            for (String s : clothingWithList.getSize()) {
                System.out.println(s);
            }
            System.out.println("===============================");
        }
    }

}