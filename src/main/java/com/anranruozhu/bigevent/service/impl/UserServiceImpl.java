package com.anranruozhu.bigevent.service.impl;

import com.anranruozhu.bigevent.mapper.UserMapper;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.pojo.User;
import com.anranruozhu.bigevent.service.UserService;
import com.anranruozhu.bigevent.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User u=userMapper.findByUsername(username);
        return u;
    }

    @Override
    public Result register(String username, String password) {
            if(userMapper.findByUsername(username)!=null){
                return Result.error("用户名已存在");
            }else{
                //进行加密
                String md5Pwd=Md5Util.getMD5String(password);
                //添加到数据库
                userMapper.add(username,md5Pwd);
                return Result.success("注册成功");
            }
    }
}
