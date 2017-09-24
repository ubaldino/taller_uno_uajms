package org.ubaldino.taller.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
  * @author ubaldino
*/
@Controller
public class OverviewController {
    
    @GetMapping("/overview")
    public String userForm(Model model,Authentication auth) {
        model.addAttribute("user",auth.getName());
        return "overview";
    }
}
