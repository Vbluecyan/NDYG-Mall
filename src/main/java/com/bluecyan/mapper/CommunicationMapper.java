package com.bluecyan.mapper;

import com.bluecyan.pojo.Communication;
import com.bluecyan.pojo.CommunicationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationMapper {
    long countByExample(CommunicationExample example);

    int deleteByExample(CommunicationExample example);

    int deleteByPrimaryKey(String communicationId);

    int insert(Communication record);

    int insertSelective(Communication record);

    List<Communication> selectByExample(CommunicationExample example);

    Communication selectByPrimaryKey(String communicationId);

    int updateByExampleSelective(@Param("record") Communication record, @Param("example") CommunicationExample example);

    int updateByExample(@Param("record") Communication record, @Param("example") CommunicationExample example);

    int updateByPrimaryKeySelective(Communication record);

    int updateByPrimaryKey(Communication record);
}