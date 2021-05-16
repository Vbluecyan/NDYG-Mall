package com.bluecyan.service.impl;

import com.bluecyan.mapper.OrderExtendMapper;
import com.bluecyan.pojo.Order;
import com.bluecyan.pojo.OrderExample;
import com.bluecyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-26 0:07
 * @Description
 **/

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderExtendMapper orderExtendMapper;

    @Override
    public boolean createOrder(Order order) {
        order.setOrderId(String.valueOf(System.currentTimeMillis()));
        order.setCreationDatetime(new Date());
        return orderExtendMapper.insertSelective(order) == 1;
    }

    @Override
    public List<Order> getAll(String userId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        // 越新的订单越在前面
        example.setOrderByClause("order_id DESC");
        return orderExtendMapper.selectByExample(example);
    }

    @Override
    public List<Order> getAllByClothing(String clothingId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andClothingIdEqualTo(clothingId);
        // 越新的订单越在前面
        example.setOrderByClause("order_id DESC");
        return orderExtendMapper.selectByExample(example);
    }

    @Override
    public boolean deleteOrder(String orderId) {
        return orderExtendMapper.deleteByPrimaryKey(orderId) == 1;
    }

    @Override
    public boolean deleteUserOrder(String userId) {
        OrderExample example = new OrderExample();
        OrderExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return orderExtendMapper.deleteByExample(example) == 1;
    }

    @Override
    public int updateByPrimaryKeySelective(Order order) {
        return orderExtendMapper.updateByPrimaryKeySelective(order);
    }
}
