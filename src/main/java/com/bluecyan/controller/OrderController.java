package com.bluecyan.controller;

import com.bluecyan.pojo.Order;
import com.bluecyan.pojo.ResultJson;
import com.bluecyan.pojo.User;
import com.bluecyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author bluecyan
 * @DateTime 2021-04-26 0:08
 * @Description
 **/

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/to-order", method = RequestMethod.GET)
    public String toOrder(@SessionAttribute(value = "user", required = false) User user, Model model) {
        if (user != null) {
            model.addAttribute("orderList",orderService.getAll(user.getUserId()));
            return "order";
        } else {
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/create-order", method = RequestMethod.POST)
    public ResultJson createOrder(String userId, String clothingId, int money, String expectantReturnDate) {
        Order order = new Order();
        order.setUserId(userId);
        order.setClothingId(clothingId);
        order.setMoney(money);

        // 客户端日期填写格式：年 月 日
        String date[] = expectantReturnDate.split(" ");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        order.setExpectantReturnDate(new Date(calendar.getTimeInMillis()));
        orderService.createOrder(order);
        return ResultJson.success();
    }

    @ResponseBody
    @RequestMapping(value = "/cancel-order/{orderId}", method = RequestMethod.DELETE)
    public ResultJson cancelOrder(@PathVariable String orderId) {
        orderService.deleteOrder(orderId);
        return ResultJson.success();
    }

    @ResponseBody
    @RequestMapping(value = "/confirm-receive/{orderId}", method = RequestMethod.PUT)
    public ResultJson confirmReceive(@PathVariable String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        Date date = new Date();
        order.setFinishDatetime(date);
        orderService.updateByPrimaryKeySelective(order);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String dateStr = df.format(date);
        dateStr = dateStr.replace("-0","-"); // 去除日期的前导0
        return ResultJson.success().addObject("dateStr",dateStr);
    }

    @ResponseBody
    @RequestMapping(value = "/return-clothing/{orderId}", method = RequestMethod.PUT)
    public ResultJson returnClothing(@PathVariable String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        Date date = new Date();
        order.setActualReturnDate(date);
        orderService.updateByPrimaryKeySelective(order);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String dateStr = df.format(date);
        dateStr = dateStr.replace("-0","-"); // 去除日期的前导0
        return ResultJson.success().addObject("dateStr",dateStr);
    }

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public ResultJson comment(@RequestBody Order order) {
        orderService.updateByPrimaryKeySelective(order);
        return ResultJson.success();
    }
}
