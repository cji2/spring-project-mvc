package edu.gmu.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD } )
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	public String value() default "GMU";
	
	// define default error message
	public String message() default "should start with GMU";
	
	/* define default groups
	 * groups can group related constraints.
	 * the following is empty collection.
	 */
	public Class<?>[] groups() default {};
	
	// define default pay-loads.
	public Class<? extends Payload>[] payload() default {};
}
