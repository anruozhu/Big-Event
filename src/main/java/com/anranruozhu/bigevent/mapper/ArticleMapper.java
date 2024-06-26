package com.anranruozhu.bigevent.mapper;

import com.anranruozhu.bigevent.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author anranruozhu
 * @ClassName ArticleMapper
 * @Description 文章数据持久化层
 * @create 2024/5/15 上午10:52
 **/
@Mapper
public interface ArticleMapper {
    void add(Article article);
    List<Article> list(Integer userId, Integer categoryId, String state);
}
