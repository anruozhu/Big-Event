package com.anranruozhu.bigevent.interceptors;

import com.anranruozhu.bigevent.pojo.Result;
import com.anranruozhu.bigevent.utils.JWTUtil;
import com.anranruozhu.bigevent.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @author anranruozhu
 * @ClassName Logininterceptor
 * @Description
 * @create 2024/5/12 下午2:34
 **/
@Component
//自定义拦截器
public class LoginInterceptor implements HandlerInterceptor {

    @Override//这是拦截器中最先被调用的方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token =request.getHeader("Authorization");
        try{
            Map<String,Object> claims= JWTUtil.parseToken(token);
            //将义务数据存储到ThreadLocal中去
            ThreadLocalUtil.set(claims);
            //放行
            return true;
        }catch(Exception e){
            response.setStatus(401);
            //进行拦截
            return false;
        }
    }

    @Override//在控制器方法处理完请求之后：这意味着无论控制器方法是正常执行结束还是抛出了未被捕获的异常，afterCompletion都会被调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
