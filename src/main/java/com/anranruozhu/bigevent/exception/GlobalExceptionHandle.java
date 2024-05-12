package com.anranruozhu.bigevent.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.anranruozhu.bigevent.pojo.Result;
/**
 * @author anranruozhu
 * @ClassName GlobalExceptionHandle
 * @Description 全局异常处理请求
 * @create 2024/5/12 下午1:21
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
    log.warn(e.getMessage());
    return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }
}
