package com.bluecyan.mapper;

import com.bluecyan.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 22:16
 * @Description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AdminExtendMapperTest {

    @Autowired
    AdminExtendMapper adminExtendMapper;

    @Test
    public void countByExample() {
        System.out.println(adminExtendMapper.countByExample(null));
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
        adminExtendMapper.deleteByPrimaryKey("admin");
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        Admin admin = new Admin();
        admin.setAdminId("admin");
        admin.setPassword("jkjk123456");
        adminExtendMapper.insertSelective(admin);
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