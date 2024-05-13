package com.anranruozhu.bigevent.mapper;

import com.anranruozhu.bigevent.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User findByUsername(String username);

    void add(String username, String password);

    void update(User user);

    void updateAvatar(String avatarUrl,Integer id);

    void updatePwd(Integer id, String password);
}
