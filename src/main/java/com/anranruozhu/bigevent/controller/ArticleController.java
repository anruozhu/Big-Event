package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Article;
import com.anranruozhu.bigevent.pojo.PageBean;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.service.ArticleService;
import com.anranruozhu.bigevent.utils.JWTUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private ArticleService articleService;
    @GetMapping
    public Result<PageBean<Article>> List(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state) {
        return articleService.list(pageNum, pageSize, categoryId, state);
    }
    @PostMapping
    public Result<String> add(@RequestBody @Validated Article article) {
        return articleService.add(article);
    }
}
