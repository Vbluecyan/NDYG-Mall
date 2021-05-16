package com.bluecyan.controller;

import com.bluecyan.pojo.ResultJson;
import com.bluecyan.pojo.SearchCondition;
import com.bluecyan.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Author bluecyan
 * @DateTime 2021-04-19 19:23
 * @Description
 **/

@Controller
@RequestMapping("/clothing")
public class ClothingController {

    @Autowired
    ClothingService clothingService;

    @Autowired
    BrandService brandService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    StyleService styleService;

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public String search(@PathVariable String keyword, Model model) {
        model.addAttribute("keyword",keyword);
        model.addAttribute("brandList", brandService.getBrandList());
        model.addAttribute("categoryList", categoryService.getCategoryList());
        model.addAttribute("styleList", styleService.getStyleList());
        return "searchPage";
    }

    //    @RequestBody必须接收post请求，故不能符合restful风格
    @ResponseBody
    @RequestMapping(value = "/search")
    public ResultJson getClothingWithListsBySearch(@RequestBody SearchCondition searchCondition) {
        return ResultJson.success().addObject("clothingListBySearchPageInfo",clothingService.getClothingListBySearch(searchCondition,60,5));
    }

    @RequestMapping(value = "/to-clothingDetails/{clotingId}", method = RequestMethod.GET)
    public String toClothingDetails(@PathVariable String clotingId, Model model) {
        model.addAttribute("clothingWithList",clothingService.getClothingWithList(clotingId));
        model.addAttribute("orderList",orderService.getAllByClothing(clotingId));
        return "clothingDetails";
    }
}
