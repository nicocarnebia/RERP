package com.javaerp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "welcome";
    }
}
