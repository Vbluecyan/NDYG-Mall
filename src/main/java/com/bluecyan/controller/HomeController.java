package com.bluecyan.controller;

import com.bluecyan.service.ClothingService;
import com.bluecyan.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author bluecyan
 * @DateTime 2021-04-17 2:47
 * @Description
 */

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @Autowired
    ClothingService clothingService;

    @RequestMapping(value = "/to-index", method = RequestMethod.GET)
    public String toIndex(Model model) {
        model.addAttribute("homeWithList",homeService.getHomeWithList(1));
        model.addAttribute("hotClothingWithLists",clothingService.getHotClothingWithLists());
        model.addAttribute("newClothingWithLists",clothingService.getNewClothingWithLists());
        return "index";
    }
}
