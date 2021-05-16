package com.bluecyan.mapper;

import com.bluecyan.pojo.Style;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 23:31
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class StyleExtendMapperTest {

    @Autowired
    StyleExtendMapper styleExtendMapper;

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
        Style style = new Style();
        String[] str = {"奢侈精选","气质优雅","甜美可爱","基础上班装","经典牛仔","街头潮流","夜店派对","舒适休闲"
                ,"度假旅行","经典大气","其他"};
        for (String s : str) {
            style.setStyleName(s);
            styleExtendMapper.insertSelective(style);
        }
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