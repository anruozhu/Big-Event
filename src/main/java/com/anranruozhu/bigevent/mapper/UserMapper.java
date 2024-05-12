package com.anranruozhu.bigevent.mapper;

import com.anranruozhu.bigevent.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    void add(String username, String password);
}