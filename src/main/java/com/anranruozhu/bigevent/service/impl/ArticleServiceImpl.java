package com.anranruozhu.bigevent.service.impl;

import com.anranruozhu.bigevent.mapper.ArticleMapper;
import com.anranruozhu.bigevent.mapper.CategoryMapper;
import com.anranruozhu.bigevent.pojo.Article;
import com.anranruozhu.bigevent.pojo.PageBean;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.service.ArticleService;
import com.anranruozhu.bigevent.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Result<PageBean<Article>> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {

        //1.创建PageBean对象
        log.info("pageNum:{}pageSize{}",pageNum,pageSize);
        PageBean<Article> pageBean = new PageBean<>();
        //2.开启分页查询PageHelper
        PageHelper.startPage(pageNum,pageSize);
        //3.调用Mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer)map.get("id");

        List<Article> as=articleMapper.list(userId,categoryId,state);

        log.info("as:{}",as);
        Page<Article> pa = (Page<Article>)as;
        //Page中提供了方法，可以获取PageHelper分页查询后，得到的总记录条数和当前页数据
        pageBean.setTotal(pa.getTotal());
        pageBean.setItems(pa.getResult());
        log.info("pageBean:{}",pa.getResult());
        return Result.success(pageBean);
    }
}
