package com.anranruozhu.bigevent.service.impl;

import com.anranruozhu.bigevent.mapper.ArticleMapper;
import com.anranruozhu.bigevent.mapper.CategoryMapper;
import com.anranruozhu.bigevent.pojo.Article;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.service.ArticleService;
import com.anranruozhu.bigevent.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author anranruozhu
 * @ClassName ArticleServiceImpl
 * @Description 文章相关服务的实现类
 * @create 2024/5/15 上午10:51
 **/
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Result<String> add(Article article) {
        try{
            Map<String,Object> map = ThreadLocalUtil.get();
            Integer userId = (Integer)map.get("id");
            article.setCreateUser(userId);
            log.info("article:{}",article);
            articleMapper.add(article);
            return Result.success();
        }catch(Exception e){
            return Result.error(e.getMessage());
        }
    }
}
