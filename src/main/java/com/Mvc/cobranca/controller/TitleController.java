package com.Mvc.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Mvc.cobranca.model.Title;



@Controller
@RequestMapping("/title")
public class TitleController {
	
	
	
	@RequestMapping("/create")
	public String create() {
		return "CreateTitle";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String save(Title title) {
		
		System.out.println(">>>" + title.getDescription());
		return "Title";
	}
	
	
}
