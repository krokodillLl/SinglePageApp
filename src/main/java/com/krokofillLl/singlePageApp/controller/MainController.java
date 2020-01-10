package com.krokofillLl.singlePageApp.controller;

import com.krokofillLl.singlePageApp.domain.Tag;
import com.krokofillLl.singlePageApp.service.JsoupService;
import com.krokofillLl.singlePageApp.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    JsoupService jsoupService;
    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String getMain(Model model) {
        if(jsoupService.isAddTags())
            jsoupService.addTags();
        Set<Tag> developTags = tagService.getDevelopTags();
        Set<Tag> adminTags = tagService.getAdminTags();
        Set<Tag> designTags = tagService.getDesignTags();
        Set<Tag> managementTags = tagService.getManagementTags();
        Set<Tag> marketingTags = tagService.getMarketingTags();
        Set<Tag> geektimesTags = tagService.getGeektimesTags();
        Set<Tag> miscTags = tagService.getMiscTags();

        model.addAttribute("developTags", developTags);
        model.addAttribute("adminTags", adminTags);
        model.addAttribute("designTags", designTags);
        model.addAttribute("managementTags", managementTags);
        model.addAttribute("marketingTags", marketingTags);
        model.addAttribute("geektimesTags", geektimesTags);
        model.addAttribute("miscTags", miscTags);

        return "main";
    }


}
