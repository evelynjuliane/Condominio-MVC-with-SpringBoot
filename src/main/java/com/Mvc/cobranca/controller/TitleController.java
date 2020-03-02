package com.Mvc.cobranca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TitleController {
	
	@RequestMapping("/title/create")
	public String create() {
		return "CreateTitle";
	}
}
