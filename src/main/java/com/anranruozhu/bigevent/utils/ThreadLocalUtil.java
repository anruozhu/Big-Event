package com.anranruozhu.bigevent.utils;

/**
 * @author anranruozhu
 * @ClassName ThreadLocalUtil
 * @Description Theadlocal工具类
 * @create 2024/5/12 下午3:22
 **/
@SuppressWarnings("all")
public class ThreadLocalUtil {
    //提供ThreadLocal对象,
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }

    //存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }


    //清除ThreadLocal 防止内存泄漏
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}