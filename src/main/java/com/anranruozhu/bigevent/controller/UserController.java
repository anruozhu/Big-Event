package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.pojo.User;
import com.anranruozhu.bigevent.service.UserService;
import com.anranruozhu.bigevent.utils.JWTUtil;
import com.anranruozhu.bigevent.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author anranruozhu
 * @ClassName UserController
 * @Description 用户接口
 * @create 2024/5/12 上午11:27
 **/
@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        return userService.register(username, password);
    }
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$")String username,@Pattern(regexp = "^\\S{5,16}$")String password) {
        return userService.login(username, password);
    }
    @GetMapping("userInfo")
    public Result<User> userinfo(/*@RequestHeader(name="Authorization")String token*/) {
//        Map<String, Object>map=JWTUtil.parseToken(token);
//        String username=(String)map.get("username");

        Map<String,Object> map= ThreadLocalUtil.get();
        String username=(String)map.get("username");
        return Result.success(userService.findByUsername(username));
    }
    @PutMapping("/update")
    public Result<String> update(@RequestBody @Validated User user) {
        return userService.update(user);
    }
    @PatchMapping("updateAvatar")
    public Result<String> updateAvatar(@RequestParam @URL String avatarUrl) {
        return userService.updateAvatar(avatarUrl);
    }
    @PatchMapping("/UpdatePwd")
    public Result UpdatePwd(@RequestBody Map<String ,String> params){
        return userService.updatePwd(params);
    }

}
