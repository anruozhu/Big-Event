package com.anranruozhu.bigevent.service;

import com.anranruozhu.bigevent.pojo.Category;
import com.anranruozhu.bigevent.pojo.Result;

import java.util.List;

public interface CategoryService {
    Result<String> add(Category category);

    Result<List<Category>> list();

    Result<Category> findById(Integer id);

    Result<String> update(Category category);
}
