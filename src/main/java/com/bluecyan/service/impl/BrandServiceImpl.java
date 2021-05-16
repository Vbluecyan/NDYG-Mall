package com.bluecyan.service.impl;

import com.bluecyan.mapper.BrandExtendMapper;
import com.bluecyan.pojo.Brand;
import com.bluecyan.pojo.BrandExample;
import com.bluecyan.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 20:59
 * @Description
 **/

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandExtendMapper brandExtendMapper;

    @Override
    public List<Brand> getBrandList() {
        return brandExtendMapper.selectByExample(null);
    }

    @Override
    public List<Integer> getBrandIdListByBrandNameLike(String brandNameLike) {
        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        criteria.andBrandNameLike("%" + brandNameLike + "%");
        List<Brand> brands = brandExtendMapper.selectByExample(brandExample);
        List<Integer> list = new ArrayList<Integer>();
        for (Brand brand : brands) {
            list.add(brand.getBrandId());
        }
        return list;
    }
}
