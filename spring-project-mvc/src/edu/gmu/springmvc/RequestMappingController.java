package edu.gmu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
/* the following is parent mapping of the child mapping, which is for methods.
 * So, this is high-level mapping
 */
@RequestMapping("/hello")
public class RequestMappingController {

	/* need a controller method to show the initial HTML form.
	 * the following is sub mapping.
	 */
	@RequestMapping("/showForm")
	public String displayForm() {
		return "helloworld-form";
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
