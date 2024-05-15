package com.anranruozhu.bigevent.controller;

import com.anranruozhu.bigevent.pojo.Category;
import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author anranruozhu
 * @ClassName CategoryConroller
 *
 * @Description 文章分类的控制类
 * @create 2024/5/13 上午11:33
 **/
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping
    public Result<String> add(@RequestBody @Validated(Category.Add.class) Category category){
        return categoryService.add(category);
    }
    @GetMapping
    public Result<List<Category>> list(){
        return categoryService.list();
    }
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
            return categoryService.findById(id);
        }
    @PutMapping
    public Result<String> update(@RequestBody @Validated(Category.Update.class) Category category){
        return categoryService.update(category);
    }


}
