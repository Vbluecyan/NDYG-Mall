package com.bluecyan.mapper;

import com.bluecyan.pojo.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 23:29
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class CategoryExtendMapperTest {

    @Autowired
    CategoryExtendMapper categoryExtendMapper;

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
        Category category = new Category();
        String[] str = {"上衣","T恤","卫衣","衬衫","西服","风衣","大衣","毛衣/针织衫","羽绒服/棉服","套装",
                "夹克/外套","长裤","裙子","连体裤","背心/马甲","中裤/短裤","其他"};
        for (String s : str) {
            category.setCategoryName(s);
            categoryExtendMapper.insertSelective(category);
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