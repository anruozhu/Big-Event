package com.anranruozhu.validation;

import com.anranruozhu.bigevent.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author anranruozhu
 * @ClassName StateValidation
 * @Description
 * @create 2024/5/15 下午2:28
 **/
public class StateValidation implements ConstraintValidator<State, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        //提供校验规则
        if(s==null)return false;
        return s.equals("已发布") || s.equals("草稿");
    }
}
