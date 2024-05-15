package com.anranruozhu.bigevent.service;

import com.anranruozhu.bigevent.pojo.Article;
import com.anranruozhu.bigevent.pojo.Result;

public interface ArticleService {
    Result<String> add(Article article);
}
