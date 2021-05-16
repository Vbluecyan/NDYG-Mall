package com.bluecyan.service.impl;

import com.bluecyan.mapper.StyleExtendMapper;
import com.bluecyan.pojo.Style;
import com.bluecyan.pojo.StyleExample;
import com.bluecyan.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author bluecyan
 * @DateTime 2021-04-21 21:05
 * @Description
 **/

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    StyleExtendMapper styleExtendMapper;

    @Override
    public List<Style> getStyleList() {
        return styleExtendMapper.selectByExample(null);
    }

    @Override
    public List<Integer> getStyleIdListByStyleNameLike(String styleNameLike) {
        StyleExample styleExample = new StyleExample();
        StyleExample.Criteria criteria = styleExample.createCriteria();
        criteria.andStyleNameLike("%" + styleNameLike + "%");
        List<Style> styles = styleExtendMapper.selectByExample(styleExample);
        List<Integer> list = new ArrayList<Integer>();
        for (Style brand : styles) {
            list.add(brand.getStyleId());
        }
        return list;
    }
}
