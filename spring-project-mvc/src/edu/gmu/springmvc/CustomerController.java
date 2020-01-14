package edu.gmu.springmvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@RequestMapping("/showForm")
	public String showForm(Model aModel) {
		
		// create a customer object
		Customer aCustomer = new Customer();
		
		/* add customer object to the model (data binding)
		 * we have a pair of the name, 'customer' and the value, aCustomer.
		 */
		aModel.addAttribute("customer", aCustomer);
		
		return "customer-form";
	}
	
	/* tell Spring to validate the Customer object using @Valid.
	 * data binding by @ModelAttribute.
	 * the result of validation will be stored in the BindingResult object.
	 * And it should be written right after @Valid annotation and its model.
	 */
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer aCustomer, 
								BindingResult theBindingResult) {
		
		System.out.println("Last name: |" + aCustomer.getLastName() + "|");
		
		if (theBindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
		
		// log the input data
		//System.out.println("a Customer: " + aCustomer.getFirstName() + " " + aCustomer.getLastName());
		//return "customer-confirmation";
	}
}