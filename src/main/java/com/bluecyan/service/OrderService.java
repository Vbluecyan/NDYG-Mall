package com.bluecyan.service;

import com.bluecyan.pojo.Order;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-26 0:07
 * @Description
 **/
public interface OrderService {

    /**
     * @Author bluecyan
     * @DateTime 2021/4/26 23:05
     * @Description 创建租衣订单，需要提供 用户ID 服装ID 单租交易价格 预期归还时间
     * @Param [order]
     * @Return boolean
     **/
    public boolean createOrder(Order order);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 0:44
     * @Description 查询某用户所有订单
     * @Param []
     * @Return java.util.List<com.bluecyan.pojo.Order>
     **/
    public List<Order> getAll(String userId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 0:44
     * @Description 查询某服装所有订单
     * @Param []
     * @Return java.util.List<com.bluecyan.pojo.Order>
     **/
    public List<Order> getAllByClothing(String clothingId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 15:20
     * @Description 删除指定订单
     * @Param []
     * @Return boolean
     **/
    public boolean deleteOrder(String orderId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 21:23
     * @Description 删除某个用户的所有订单（用户注销时用）
     * @Param [userId]
     * @Return boolean
     **/
    public boolean deleteUserOrder(String userId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 15:39
     * @Description 根据主键选择性更新数据
     * @Param [record]
     * @Return int
     **/
    int updateByPrimaryKeySelective(Order order);
}
