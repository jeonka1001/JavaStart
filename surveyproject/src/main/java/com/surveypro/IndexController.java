package com.surveypro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("result",null);
        return "index";
    }
    @GetMapping("/siteInfo")
    public String info(){
        System.out.println("info()");
        return "siteInfo";
    }
    @GetMapping("/siteRule")
    public String rule(){
        System.out.println("IndexController.rule");
        return "siteRule";
    }
}
