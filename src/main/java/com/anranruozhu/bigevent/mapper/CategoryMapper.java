package com.anranruozhu.bigevent.mapper;

import com.anranruozhu.bigevent.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    void add(Category category);

    List<Category> list(Integer userId);

    Category findById(Integer id, Integer userId);

    void update(Category category);
}
