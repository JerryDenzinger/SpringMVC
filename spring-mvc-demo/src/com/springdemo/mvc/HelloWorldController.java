package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial HTML form 
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form 
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String allCapitals(HttpServletRequest request,Model model) {
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all CAPITAL letters
		theName = theName.toUpperCase();
		
		// create the message 
	    String result = "Say my name and say it loud LOL!!!!!!!! " + theName;
	    
	    // add message to the model 
	    model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormThree(@RequestParam ("studentName") String theName ,Model model) {
	
		// convert the data to all CAPITAL letters
		theName = theName.toUpperCase();
		
		// create the message 
	    String result = "Hello And Welcom to Tomorrowland!!!!!!!! " + theName;
	    
	    // add message to the model 
	    model.addAttribute("message", result);
		
		return "helloworld";
	}

}
