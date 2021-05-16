package com.bluecyan.service;

import com.bluecyan.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-26 23:15
 * @Description
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    public void createOrder() {
        Order order = new Order();
        order.setUserId("jk");
        order.setClothingId("1619178881459");
        order.setMoney(174);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2021,11,30);
        order.setExpectantReturnDate(new Date(calendar.getTimeInMillis()));

        orderService.createOrder(order);
    }

    @Test
    public void getAll() {
        List<Order> jk = orderService.getAll("jk");
        for (Object o : jk) {
            System.out.println(o);
        }

    }
}