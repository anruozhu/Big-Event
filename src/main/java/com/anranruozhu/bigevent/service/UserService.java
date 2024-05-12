package com.anranruozhu.bigevent.service;

import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    //根据用户名查询用户
    User findByUsername(String username);
    //进行注册服务
    Result<String> register(String username, String password);

    Result<String> login(String username, String password);
}
