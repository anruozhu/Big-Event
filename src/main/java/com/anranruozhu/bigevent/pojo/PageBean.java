package com.anranruozhu.bigevent.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author anranruozhu
 * @ClassName PageBean
 * @Description 分页返回结果对象
 * @create 2024/5/15 下午2:48
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean <T>{
    private Long total;//总条数
    private List<T> items;//当前页数据集合
}
