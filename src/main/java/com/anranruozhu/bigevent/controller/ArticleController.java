package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anranruozhu
 * @ClassName ArticleController
 * @Description 需要登陆认证才可以访问的接口
 * @create 2024/5/12 下午1:40
 **/
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> List(){
        return Result.success("所有的文章数据");
    }
}
