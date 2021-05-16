package com.bluecyan.service;

import com.bluecyan.pojo.User;
import org.springframework.util.DigestUtils;

/**
 * @Author bluecyan
 * @DateTime 2021-04-18 0:14
 * @Description
 **/
public interface UserService {

    User getUser(String userId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/18 0:20
     * @Description 注册用户
     * @Param [user]
     * @Return int
     **/
    boolean register(User user);

    boolean login(User user);

    boolean updatePassword(User user);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/18 1:35
     * @Description 校验是否存在user_id为userId的用户
     * @Param [userId]
     * @Return boolean
     **/
    boolean hasUserId(String userId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/18 14:50
     * @Description 获取字符串str的MD5码
     * @Param [str]
     * @Return java.lang.String
     **/
    static String getMD5(String str) {
        //混淆原数据的盐
        String slat = "&%5123*l^QAQs%j!flhl**&%(-_=><#)$#@";
        String base = str + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    };

    int updateByPrimaryKeySelective(User record);

    boolean deleteByPrimaryKey(String userId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/26 20:08
     * @Description 将 clothing 添加到收藏
     * @Param [clothingId]
     * @Return boolean
     **/
    boolean addFavorites(String userId, String clothingId);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/26 20:58
     * @Description 删除收藏中的一项
     * @Param [userId, clothingId]
     * @Return boolean
     **/
    boolean removeFavorites(String userId, String clothingId);

}
