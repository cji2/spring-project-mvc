package edu.gmu.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode aCourseCode) {
		coursePrefix = aCourseCode.value();
	}
	
	// we can place additional error message at 'aConstraintValidatorContext'
	@Override
	public boolean isValid(String aCode, ConstraintValidatorContext aConstraintValidatorContext) {
		
		boolean result;
		
		if (aCode != null)
			result = aCode.startsWith(coursePrefix);
		else
			result = true;
		
		return result;
	}
}
