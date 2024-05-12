package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    public Result<String> List() {
//        try{
//            Map<String,Object> claims= JWTUtil.parseToken(token);
//            return Result.success(claims.get("username").toString());
//        }catch(Exception e){
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("文章数据");
    }
}
