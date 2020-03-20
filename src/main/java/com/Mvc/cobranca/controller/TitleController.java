package com.Mvc.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Mvc.cobranca.model.StatusTitle;
import com.Mvc.cobranca.model.Title;
import com.Mvc.cobranca.repository.TitleFilter;
import com.Mvc.cobranca.repository.Titles;
import com.Mvc.cobranca.services.CreateTitleServices;



@Controller
@RequestMapping("/title")
public class TitleController {

	private static final String CREATE_VIEW = "CreateTitle";
	
	@Autowired
    private Titles titles;
    
	@Autowired
	private CreateTitleServices services;
	
	//LIST
    @RequestMapping
	public ModelAndView index(@ModelAttribute("filter") TitleFilter filter) {
    	
    	String description = filter.getDescription() == null ? "" : filter.getDescription();
    	Iterable<Title> allTitles= titles.findByDescriptionContaining(description);
    	
		ModelAndView mv = new ModelAndView("Title");
		
		mv.addObject("titles", allTitles);
		return mv;

	}
    //CREATE
    @RequestMapping("/create")
    public ModelAndView create() {
    	ModelAndView mv = new ModelAndView(CREATE_VIEW);
    	mv.addObject(new Title());
        return mv;
    }
    //SAVE
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Validated Title title, Errors errors, RedirectAttributes attributes) {
    	
    	if(errors.hasErrors()) {
    		return CREATE_VIEW;
    	}   	
	    try {
	    	services.save(title);
		    attributes.addFlashAttribute("menssage", "Título salvo com sucesso!");
		    return "redirect:/title/create" ;
	    }catch(IllegalArgumentException e){
	    	errors.rejectValue("dueDate", null, e.getMessage());
	    	return CREATE_VIEW;
	    }
	    
    	
    }
   //EDIT      
    @RequestMapping("{code}")
    public ModelAndView edit(@PathVariable("code") Title title) {
    	ModelAndView mv = new ModelAndView(CREATE_VIEW);
		mv.addObject(title);
		return mv;
	}
    //DELETE
    @RequestMapping("/delete/{code}")
    public String delete(@PathVariable("code") Title title) {
    	this.titles.delete(title);
        return "redirect:/title";
    }
    
    @ModelAttribute("allStates")
    public List<StatusTitle> allStates(){
    	return Arrays.asList(StatusTitle.values());
    }
    
    
}
