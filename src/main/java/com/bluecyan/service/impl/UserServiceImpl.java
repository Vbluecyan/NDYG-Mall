package com.bluecyan.service.impl;

import com.bluecyan.mapper.UserExtendMapper;
import com.bluecyan.pojo.User;
import com.bluecyan.pojo.UserExample;
import com.bluecyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author bluecyan
 * @DateTime 2021-04-18 0:15
 * @Description
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserExtendMapper userExtendMapper;

    @Override
    public User getUser(String userId) {
        return userExtendMapper.selectByPrimaryKey(userId);
    }

    @Override
    public boolean register(User user) {
        //对密码进行MD5加密
        user.setPassword(UserService.getMD5(user.getPassword()));
        return userExtendMapper.insertSelective(user) == 1;
    }

    @Override
    public boolean login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        criteria.andPasswordEqualTo(UserService.getMD5(user.getPassword()));
        return userExtendMapper.countByExample(example) == 1;
    }

    @Override
    public boolean updatePassword(User user) {
        //对密码进行MD5加密
        user.setPassword(UserService.getMD5(user.getPassword()));
        return userExtendMapper.updateByPrimaryKeySelective(user) == 1;
    }


    @Override
    public boolean hasUserId(String userId) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return userExtendMapper.countByExample(example) == 1;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userExtendMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public boolean deleteByPrimaryKey(String userId) {
        return userExtendMapper.deleteByPrimaryKey(userId) == 1;
    }

    @Override
    @Transactional // 开启事务
    public boolean addFavorites(String userId, String clothingId) {
        String favorites = userExtendMapper.selectByPrimaryKey(userId).getFavorites();
        // 如果已经收藏了，直接返回true，防止数据重复
        if (favorites.contains(clothingId)) return true;
        favorites += clothingId+",";
        User user = new User();
        user.setUserId(userId);
        user.setFavorites(favorites);
        return userExtendMapper.updateByPrimaryKeySelective(user) == 1;
    }

    @Override
    @Transactional
    public boolean removeFavorites(String userId, String clothingId) {
        String favorites = userExtendMapper.selectByPrimaryKey(userId).getFavorites();
        favorites = favorites.replace(clothingId+",","");
        User user = new User();
        user.setUserId(userId);
        user.setFavorites(favorites);
        return userExtendMapper.updateByPrimaryKeySelective(user) == 1;
    }
}
