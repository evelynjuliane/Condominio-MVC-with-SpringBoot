package com.Mvc.cobranca.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Mvc.cobranca.model.StatusTitle;
import com.Mvc.cobranca.model.Title;
import com.Mvc.cobranca.repository.Titles;



@Controller
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private Titles titles;

    @RequestMapping("/create")
    public ModelAndView create() {
    	ModelAndView mv = new ModelAndView("CreateTitle");
        return mv;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Title title) {
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
