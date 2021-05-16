package com.bluecyan.service;

import com.bluecyan.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author bluecyan
 * @DateTime 2021-04-18 1:43
 * @Description
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    public void getUser() {
        User user = userService.getUser("jk");
        System.out.println(user.getUserId());
        System.out.println(user.getPassword());
        System.out.println(user.getNickname());
        System.out.println(user.getSex());
    }


    @Test
    public void register() {
    }

    @Test
    public void login() {
        User user = new User();
        user.setUserId("jk");
        user.setPassword("123456");
        System.out.println(userService.login(user));
    }

    @Test
    public void hasUserId() {
        System.out.println(userService.hasUserId("ppp"));
    }


    @Test
    public void getMD5() {
        System.out.println(UserService.getMD5(";sldjfljsljfls;jflsjd;lfj"));
    }

    @Test
    public void addFavorites() {
        userService.addFavorites("jk","1619178875749");
        userService.addFavorites("jk","1619178878574");
    }

    @Test
    public void removeFavorites() {
        userService.removeFavorites("jk","1619178875749");
        userService.removeFavorites("jk","1619178878574");
    }

}