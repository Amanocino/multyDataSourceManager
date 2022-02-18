package org.example.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhicheng chen
 * @date : 2022/2/18
 * @time : 15:51
 */
public class EnumStringValidator implements ConstraintValidator<EnumStringValidatorAnnotation, String> {
    private List<String> enumStringList;

    @Override
    public void initialize(EnumStringValidatorAnnotation constraintAnnotation) {
        enumStringList = Arrays.asList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        return enumStringList.contains(value);
    }
}
