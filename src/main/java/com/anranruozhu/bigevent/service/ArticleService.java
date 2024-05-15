package com.anranruozhu.bigevent.service;

import com.anranruozhu.bigevent.pojo.Article;
import com.anranruozhu.bigevent.pojo.PageBean;
import com.anranruozhu.bigevent.pojo.Result;

public interface ArticleService {
    Result<String> add(Article article);

    Result<PageBean<Article>> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
