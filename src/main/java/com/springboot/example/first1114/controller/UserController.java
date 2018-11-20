package com.springboot.example.first1114.controller;

import com.springboot.example.first1114.entity.User;
import com.springboot.example.first1114.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User控制层
 * 提供两个接口：
 * /user/index 返回页面
 * /user/show返回数据
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index(){
        return "user/index";
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public String show(@RequestParam(value = "name")String name){
        User user = userService.findUserByName(name);
        if (null != user)
            return user.getId() + "/" + user.getName() + "/" + user.getPassword();
        else
            return "null";
    }
}
