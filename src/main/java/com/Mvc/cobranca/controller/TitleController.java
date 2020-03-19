package com.Mvc.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Mvc.cobranca.model.StatusTitle;
import com.Mvc.cobranca.model.Title;
import com.Mvc.cobranca.repository.Titles;



@Controller
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private Titles titles;
    
    @RequestMapping
	public ModelAndView index() {
		
		List<Title> allTitles = titles.findAll();

		ModelAndView mv = new ModelAndView("Title");
		
		mv.addObject("titles", allTitles);
		return mv;

	}

    @RequestMapping("/create")
    public ModelAndView create() {
    	ModelAndView mv = new ModelAndView("CreateTitle");
    	mv.addObject(new Title());
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Validated Title title, Errors errors, RedirectAttributes attributes) {
    	
    	if(errors.hasErrors()) {
    		return "CreateTitle";
    	}   	
	    	titles.save(title);
	    	attributes.addFlashAttribute("menssage", "Título salvo com sucesso!");
	        return "redirect:/title/create" ;
    }
    
    @ModelAttribute("allStates")
    public List<StatusTitle> allStates(){
    	return Arrays.asList(StatusTitle.values());
    }
}
