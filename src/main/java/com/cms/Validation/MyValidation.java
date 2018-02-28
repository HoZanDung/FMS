package com.cms.Validation;

import com.cms.entity.BaseModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by HOZANDUNG on 17/5/23.
 */

public class MyValidation<M extends BaseModel> {

    private static Validator validator;

    public MyValidation() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public void ValidatorData(M m) {
        Set<ConstraintViolation<M>> violations = validator.validate(m);
        if(violations.size() == 0) {
            System.out.println("没想到先写着");
            return;
        }else {
            StringBuffer buf = new StringBuffer();
            for(ConstraintViolation<M> violation: violations) {
                buf.append(violation.getMessage() + "\n");
            }
            System.out.println(buf.toString());
        }
    }


}
