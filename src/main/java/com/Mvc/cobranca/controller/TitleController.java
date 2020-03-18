package com.Mvc.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Mvc.cobranca.Titles;
import com.Mvc.cobranca.model.Title;



@Controller
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private Titles titles;

    @RequestMapping("/create")
    public String create() {
        return "CreateTitle";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String save(Title title) {

        titles.save(title);
        return  "redirect:/title/create";
    }
}
