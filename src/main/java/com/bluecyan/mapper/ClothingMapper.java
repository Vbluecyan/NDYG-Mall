package com.bluecyan.mapper;

import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.ClothingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingMapper {
    long countByExample(ClothingExample example);

    int deleteByExample(ClothingExample example);

    int deleteByPrimaryKey(String clothingId);

    int insert(Clothing record);

    int insertSelective(Clothing record);

    List<Clothing> selectByExample(ClothingExample example);

    Clothing selectByPrimaryKey(String clothingId);

    int updateByExampleSelective(@Param("record") Clothing record, @Param("example") ClothingExample example);

    int updateByExample(@Param("record") Clothing record, @Param("example") ClothingExample example);

    int updateByPrimaryKeySelective(Clothing record);

    int updateByPrimaryKey(Clothing record);
}