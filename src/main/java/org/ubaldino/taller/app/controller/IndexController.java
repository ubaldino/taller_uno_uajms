package org.ubaldino.taller.app.controller;

import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ubaldino.taller.app.service.DateService;
/**
 *
 * @author ubaldino
 */
@Controller
public class IndexController {
    
    private @Autowired DateService dateService;
    /**
      * This method will list all existing users.
     * @param model
      * @param auth
      * @return 
    */
    @RequestMapping(value={"/"},method=RequestMethod.GET)
    public String index(Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        model.addAttribute("auth",auth);
        model.addAttribute("date",dateService.getCurrentDate());
        return "index";
    }
}
