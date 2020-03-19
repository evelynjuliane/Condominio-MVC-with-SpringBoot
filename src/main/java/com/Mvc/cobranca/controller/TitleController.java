package com.Mvc.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Mvc.cobranca.model.StatusTitle;
import com.Mvc.cobranca.model.Title;
import com.Mvc.cobranca.repository.Titles;



@Controller
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private Titles titles;
    
    @RequestMapping
	public ModelAndView index(@RequestParam(defaultValue="") String description) {
		
		Iterable<Title> allTitles = titles.findByDescriptionContaining(description);

		ModelAndView mv = new ModelAndView("Title");
		
		mv.addObject("titulos", allTitles);
		return mv;

	}

    @RequestMapping("/create")
    public ModelAndView create() {
    	ModelAndView mv = new ModelAndView("CreateTitle");
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Title title) {
    	System.out.println(title.getValue());
    	titles.save(title);
    	ModelAndView mv = new ModelAndView("CreateTitle");
    	mv.addObject("menssage", "Título salvo com sucesso!");
        return mv ;
    }
    
    @ModelAttribute("allStates")
    public List<StatusTitle> allStates(){
    	return Arrays.asList(StatusTitle.values());
    }
}
