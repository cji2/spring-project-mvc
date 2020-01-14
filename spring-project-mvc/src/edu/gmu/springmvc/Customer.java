package edu.gmu.springmvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import edu.gmu.springmvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=2, message="is required")
	private String lastName;
	
//	@CourseCode
	@CourseCode(value="GMU", message="should start with GMU")
	private String courseCode;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
