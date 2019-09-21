package com.wp.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckSalaryValidator implements ConstraintValidator<CheckSalary, Integer> {

	@Override
	public void initialize(CheckSalary constraintAnnotation) {
		// TODO Auto-generated method stub	
	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value>10000 && value<10000000;//salary should be between 10k and 1cr 
	}

}
