package edu.gmu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showForm")
	public String showForm(Model aModel) {
		
		// create a student object
		Student aStudent = new Student();
		//Student aStudent = new Student("David", "Ji");
		
		/* add student object to the model
		 * we have a pair of the name, 'student' and the value, aStudent.
		 */
		aModel.addAttribute("student", aStudent);
		
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student aStudent) {
		
		// log the input data
		System.out.println("a Student: " + aStudent.getFirstName() + " " + aStudent.getLastName());
		return "student-confirmation";
	}
}
