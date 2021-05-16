package com.bluecyan.controller;

import com.bluecyan.pojo.ResultJson;
import com.bluecyan.pojo.User;
import com.bluecyan.service.ClothingService;
import com.bluecyan.service.OrderService;
import com.bluecyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


/**
 * @Author bluecyan
 * @DateTime 2021-04-17 22:16
 * @Description
 **/

@Controller
@RequestMapping("/user")
@SessionAttributes(names = {"user"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ClothingService clothingService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/to-register", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }


    @RequestMapping(value = "/to-login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/to-personalHomepage", method = RequestMethod.GET)
    public String toPersonalHomepage(@SessionAttribute(value = "user", required = false) User user) {
        if (user != null) {
            return "personalHomepage";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/to-favorites", method = RequestMethod.GET)
    public String toFavorites(@SessionAttribute(value = "user", required = false) User user,Model model) {
        if (user != null) {
            model.addAttribute("favoritesClothingWithLists",clothingService.getClothingWithLists(user.getFavorites()));
            return "favorites";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/to-suitcase", method = RequestMethod.GET)
    public String toSuitcase(@SessionAttribute(value = "user", required = false) User user) {
        if (user != null) {
            return "suitcase";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/to-personal-data", method = RequestMethod.GET)
    public String toPersonData(@SessionAttribute(value = "user", required = false) User user) {
        if (user != null) {
            return "personalData";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/to-account-set", method = RequestMethod.GET)
    public String toAccountSet(@SessionAttribute(value = "user", required = false) User user) {
        if (user != null) {
            return "accountSet";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/to-member", method = RequestMethod.GET)
    public String toMember(@SessionAttribute(value = "user", required = false) User user) {
        if (user != null) {
            return "member";
        } else {
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/check-user", method = RequestMethod.GET)
    public ResultJson checkUser(String userId, String password) {
        if (userService.hasUserId(userId)) {
            return ResultJson.fail().addObject("userIdError","用户ID已经存在！");
        } else {
            return ResultJson.success();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResultJson register(String userId, String password, Model model) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        userService.register(user);
        model.addAttribute("user",userService.getUser(userId));
        return ResultJson.success().addObject("toUrl","/user/to-personalHomepage");
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResultJson login(String userId, String password, Model model) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        if (userService.login(user)) {
            model.addAttribute("user",userService.getUser(userId));
            return ResultJson.success().addObject("toUrl","/user/to-personalHomepage");
        } else {
            return ResultJson.fail().addObject("userIdOrPasswordError","用户ID或密码错误！");
        }
    }

    @RequestMapping(value = "/login-out", method = RequestMethod.GET)
    public String loginOut(SessionStatus sessionStatus) {
        //清除session数据
        sessionStatus.setComplete();
        return "login";
    }

    // 还是啥好用用啥爽……强制restful风格太难搞,特别是涉及到通过post请求体传输JSON数据时
    // 用post发请求，设置_method=put/_method=delete,就可以封装JSON数据到请求体了
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResultJson updateByPrimaryKeySelective(@RequestBody User user, Model model) {
        userService.updateByPrimaryKeySelective(user);
        User userPojo = userService.getUser(user.getUserId());

        //         清除旧的用户信息，保存新的用户信息
        //        sessionStatus.setComplete();
        //  不能用sessionStatus.setComplete();后再保存，貌似有状态信息被清除了，用存入同名对象的方式覆盖掉原本的user
        model.addAttribute("user",userPojo);

        return ResultJson.success().addObject("user",userPojo);
    }

    // 传JSON对象实在是太好用了，数据都封装的明明白白，要几个数据就封装几个
    @ResponseBody
    @RequestMapping(value = "/check-current-password", method = RequestMethod.POST)
    public ResultJson checkCurrentPassword(@RequestBody User user) {
        if (userService.login(user)) {
            return ResultJson.success();
        } else {
            return ResultJson.fail();
        }
    }

    // jsp只能接收get请求和post请求,这里如果为了restful设置成put请求，则无法跳转页面（接收put请求，跳转页面也用的put请求）
    @RequestMapping(value = "/update-password/{userId}/{newPassword}")
    public String updatePassword(@PathVariable String userId, @PathVariable String newPassword, SessionStatus sessionStatus) {
        User user = new User();
        user.setUserId(userId);
        user.setPassword(newPassword);
        userService.updatePassword(user);
        sessionStatus.setComplete();
        return "login";
    }

    // jsp只能接收get请求和post请求,这里如果为了restful设置成delete请求，则无法跳转页面（接收delete请求，跳转页面也用的delete请求）
    @RequestMapping(value = "/delete-user/{userId}")
    public String deleteUser(@PathVariable String userId, SessionStatus sessionStatus) {
        // 注销账号前先删除所有相关的数据 这个demo只有订单
        orderService.deleteUserOrder(userId);
        userService.deleteByPrimaryKey(userId);
        sessionStatus.setComplete();
        return "register";
    }

    @ResponseBody
    @RequestMapping(value = "/become-member/{userId}", method = RequestMethod.PUT)
    public ResultJson becomeMember(@PathVariable String userId,  Model model) {
        User user = new User();
        user.setUserId(userId);
        user.setMember((byte) 1);
        userService.updateByPrimaryKeySelective(user);
        User userPojo = userService.getUser(user.getUserId());

        //         清除旧的用户信息，保存新的用户信息
        //        sessionStatus.setComplete();
        //  不能用sessionStatus.setComplete();后再保存，貌似有状态信息被清除了，用存入同名对象的方式覆盖掉原本的user
        model.addAttribute("user",userPojo);

        return ResultJson.success().addObject("user",userPojo);
    }

    @ResponseBody
    @RequestMapping(value = "/add-favorites/{userId}/{clothingId}", method = RequestMethod.PUT)
    public ResultJson addFavorites(@PathVariable String userId, @PathVariable String clothingId, Model model) {
        userService.addFavorites(userId,clothingId);
        User userPojo = userService.getUser(userId);

        //         清除旧的用户信息，保存新的用户信息
        //        sessionStatus.setComplete();
        //  不能用sessionStatus.setComplete();后再保存，貌似有状态信息被清除了，用存入同名对象的方式覆盖掉原本的user
        model.addAttribute("user",userPojo);

        return ResultJson.success();
    }

    @ResponseBody
    @RequestMapping(value = "/remove-favorites/{userId}/{clothingId}", method = RequestMethod.PUT)
    public ResultJson removeFavorites(@PathVariable String userId, @PathVariable String clothingId, Model model) {
        userService.removeFavorites(userId,clothingId);
        User userPojo = userService.getUser(userId);

        //         清除旧的用户信息，保存新的用户信息
        //        sessionStatus.setComplete();
        //  不能用sessionStatus.setComplete();后再保存，貌似有状态信息被清除了，用存入同名对象的方式覆盖掉原本的user
        model.addAttribute("user",userPojo);

        return ResultJson.success();
    }

    /**
     * @Author bluecyan
     * @DateTime 2021/4/27 23:52
     * @Description 头像上传
     * @Param [picname, uploadFile, request]
     * @Return java.lang.String
     **/
    @RequestMapping(value = "/file-upload")
    public String profilePhoto(String userId, Model model, MultipartFile uploadFile, HttpServletRequest request) throws Exception {
        // 先获取到要上传的文件目录 从硬盘盘符（F:\）开始的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/assets/profile_photo");
        // 创建File对象，一会向该路径下上传文件
        File file = new File(path);
        // 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
        // 获取到上传文件的名称
        String filename = uploadFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        // 把文件的名称唯一化
        filename = uuid+"_"+filename;
        // 上传文件
        uploadFile.transferTo(new File(file,filename));

        User user = new User();
        user.setUserId(userId);
        user.setProfilePhoto("assets/profile_photo/"+filename);
        userService.updateByPrimaryKeySelective(user);
        //         清除旧的用户信息，保存新的用户信息
        //        sessionStatus.setComplete();
        //  不能用sessionStatus.setComplete();后再保存，貌似有状态信息被清除了，用存入同名对象的方式覆盖掉原本的user
        model.addAttribute("user",userService.getUser(userId));

        // 内联框架中页面发来的请求，也返回内联框架中的页面
        return "personalData";
    }

}
