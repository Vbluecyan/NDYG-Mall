package com.bluecyan.mapper;

import com.bluecyan.pojo.UserRentOrder;
import com.bluecyan.pojo.UserRentOrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRentOrderMapper {
    long countByExample(UserRentOrderExample example);

    int deleteByExample(UserRentOrderExample example);

    int deleteByPrimaryKey(String userRentOrderId);

    int insert(UserRentOrder record);

    int insertSelective(UserRentOrder record);

    List<UserRentOrder> selectByExample(UserRentOrderExample example);

    UserRentOrder selectByPrimaryKey(String userRentOrderId);

    int updateByExampleSelective(@Param("record") UserRentOrder record, @Param("example") UserRentOrderExample example);

    int updateByExample(@Param("record") UserRentOrder record, @Param("example") UserRentOrderExample example);

    int updateByPrimaryKeySelective(UserRentOrder record);

    int updateByPrimaryKey(UserRentOrder record);
}