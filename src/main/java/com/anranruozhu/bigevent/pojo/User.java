package com.anranruozhu.bigevent.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author anranruozhu
 * @ClassName User
 * @Description 用户实体类
 * @create 2024/5/12 上午11:16
 **/
@Data
public class User {
    private Integer id;//主键ID
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String userPic;//用户头像地址
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}