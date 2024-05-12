package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.pojo.User;
import com.anranruozhu.bigevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anranruozhu
 * @ClassName UserController
 * @Description 用户接口
 * @create 2024/5/12 上午11:27
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public Result register(String username,String password){
        //查询用户
        User u=userService.findByUsername(username);
        if(u==null){
            //没有占用即可注册
            userService.register(username ,password);
            return Result.success("注册成功！");
        }else{
            return Result.error("用户名已被占用");
        }
    }

}
