package edu.gmu.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form.
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	/* new a controller method to read form data and add data to the model */
	@RequestMapping("/processFormTwo")
	public String addingDataToModel(HttpServletRequest request, Model model) {
		
		// read the request parameter from the HTML form
		String aName = request.getParameter("aName");

		// convert the data to all caps
		aName = aName.toUpperCase();
		
		// create the message.
		String result = "Hello! " + aName;
		
		// add message to the model, which is a pair of name("message") and value(result).
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	/* new a controller method to read form data and add data to the model */
	@RequestMapping("/processFormThree")
	public String bindVaribleByAnnotation(@RequestParam("aName") String aName, 
																	Model model) {
		
		// convert the data to all caps
		aName = aName.toUpperCase();
		
		// create the message.
		String result = "Dear " + aName;
		
		// add message to the model, which is a pair of name("message") and value(result).
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}