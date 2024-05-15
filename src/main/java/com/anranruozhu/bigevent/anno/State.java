package com.anranruozhu.bigevent.anno;

import com.anranruozhu.validation.StateValidation;
import jakarta.validation.Constraint;

import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented//元注解
//元注解，表示注解用在什么对象上面，这里留的是字段，我们自定义的注解准备用于字段上
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)//元注解，注明注解的生命周期。用来表示注解在运行时生效
@Constraint(
        validatedBy = {StateValidation.class }//取指定提供的校验规则的类
)
//自定义的参数验证注解
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的只能是'已发布'|'草稿'";

    //指定分组
    Class<?>[] groups() default {};
    //负载，获取state注解的附件信息
    Class<? extends Payload>[] payload() default {};
}
