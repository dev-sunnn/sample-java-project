package com.example.app.controller;

//import java.util.Date;

import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @RequestMapping({ "/", "/index" })
    public ModelAndView get(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }

    // @GetMapping(value = "/thymeleaf")
    // public String displayList(Model model) {
    //     //Date date = new Date();
    //     //model.addAttribute("date", date);
    //     return "thymeleaf";
    // }
}
