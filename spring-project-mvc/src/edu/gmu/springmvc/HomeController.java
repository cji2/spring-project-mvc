package edu.gmu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	// define controller method.
	@RequestMapping("/")
	public String showPage() {
		// complete return name will be made by spring-project-mvc-servlet.xml file
		return "main-menu";
	}
}
