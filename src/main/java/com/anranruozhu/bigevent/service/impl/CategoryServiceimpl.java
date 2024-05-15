package com.anranruozhu.bigevent.service.impl;

import com.anranruozhu.bigevent.mapper.CategoryMapper;
import com.anranruozhu.bigevent.pojo.Category;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.service.CategoryService;
import com.anranruozhu.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author anranruozhu
 * @ClassName CategoryServiceimpl
 * @Description
 * @create 2024/5/13 上午11:36
 **/
@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public Result<String> add(Category category) {
        Map<String ,Object> params =ThreadLocalUtil.get();
        Integer id=(Integer) params.get("id");
        category.setCreateUser(id);
       try{
           categoryMapper.add(category);
           return Result.success("添加成功");
       }catch(Exception e){
           return Result.error("添加失败");
       }
    }

    @Override
    public Result<List<Category>> list() {
        try{
            Map<String ,Object> params =ThreadLocalUtil.get();
            Integer userid=(Integer) params.get("id");
            List<Category> list = categoryMapper.list(userid);
            return Result.success(list);
        }catch (Exception e){
            return Result.error("获取失败");
        }
    }
}
