package com.krokofillLl.singlePageApp.controller;

import com.krokofillLl.singlePageApp.service.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    JsoupService jsoupService;

    @GetMapping("/")
    public String getMain() {
        if(jsoupService.isAddTags())
            jsoupService.addTags();
        return "main";
    }


}
