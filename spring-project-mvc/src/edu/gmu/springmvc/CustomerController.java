package edu.gmu.springmvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/* the following is for pre-processing every String form data.
	 * it removes leading and trailing white space.
	 * if String only has white spaces, it trims it to null.
	 * @InitBinder: pre-process all web requests coming into our Controller. */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		/* StringTrimmerEditor is defined in Spring API.
		 * (its argument is null, which means trimming to null) */
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		// it will be registered as customized editor, so it works for every string class.
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
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