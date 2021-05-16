package com.bluecyan.mapper;

import com.bluecyan.pojo.Home;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 23:30
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class HomeExtendMapperTest {

    @Autowired
    HomeExtendMapper homeExtendMapper;

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        String navigation_left = "上衣,T恤,卫衣,衬衫,西服,风衣,大衣,长裤,裙子,连体裤,";
        String navigation_bar = "奢侈精选,气质优雅,甜美可爱,基础上班装,经典牛仔,街头潮流,";
        String sideshow = "assets/sideshow/sideshow1.jpg,assets/sideshow/sideshow2.jpg,assets/sideshow/sideshow3.jpg,assets/sideshow/sideshow4.jpg,assets/sideshow/sideshow5.jpg,";
        String recommend = "1618765923003,1618765925435,1618765926444,1618765926900,1618765927788,1618765928011,1618765928635,1618765929027,1618765929611,1618765930315,1618765929811,1618765930411,";
        Home home = new Home();
        home.setNavigationLeft(navigation_left);
        home.setNavigationBar(navigation_bar);
        home.setSideshow(sideshow);
        home.setRecommend(recommend);
        homeExtendMapper.insertSelective(home);
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}