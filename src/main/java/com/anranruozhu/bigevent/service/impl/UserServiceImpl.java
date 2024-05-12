package com.anranruozhu.bigevent.service.impl;

import com.anranruozhu.bigevent.mapper.UserMapper;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.pojo.User;
import com.anranruozhu.bigevent.service.UserService;
import com.anranruozhu.bigevent.utils.JWTUtil;
import com.anranruozhu.bigevent.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anranruozhu
 * @ClassName UserServiceImpl
 * @Description 用户相关服务实现类
 * @create 2024/5/12 上午11:31
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User u = userMapper.findByUsername(username);
        return u;
    }

    @Override
    public Result<String> register(String username, String password) {
        if (userMapper.findByUsername(username) != null) {
            return Result.error("用户名已存在");
        } else {
            //进行加密
            String md5Pwd = Md5Util.getMD5String(password);
            //添加到数据库
            userMapper.add(username, md5Pwd);
            return Result.success("注册成功");
        }
    }

    @Override
    public Result<String> login(String username, String password) {
        User u = userMapper.findByUsername(username);
        if (u == null) {
            return Result.error("用户名不存在");
        }
        if (Md5Util.checkPassword(password, u.getPassword())) {
            //生成JWT
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            String token = JWTUtil.genToken(claims);
            return Result.success(token);
        } else {
            return Result.error("密码错误");
        }

    }
}
