package com.bluecyan.mapper;

import com.bluecyan.pojo.Clothing;
import com.bluecyan.pojo.SearchCondition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-16 23:04
 * @Description
 */

@Repository
public interface ClothingExtendMapper extends ClothingMapper{


    /**
     * @Author bluecyan
     * @DateTime 2021/4/22 19:26
     * @Description 根据 搜索条件searchCondition 查询对应的 List<Clothing>
     * @Param [searchCondition]
     * @Return java.util.List<com.bluecyan.pojo.Clothing>
     **/
    List<Clothing> getClothingListBySearch(SearchCondition searchCondition);

    /**
     * @Author bluecyan
     * @DateTime 2021/4/26 0:48
     * @Description 带有级联的查询，会封装 brand category style 的具体信息
     * @Param [clothingId]
     * @Return com.bluecyan.pojo.Clothing
     **/
    Clothing getAll(String clothingId);
}
