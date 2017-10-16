package org.ubaldino.taller.app.controller;

import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author ubaldino
 */
@Controller
public class LoginController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String displayLogin(Model model){
        if (!Base.hasConnection()) Base.open();
        /*
        LOGGER.debug("***************");
        LOGGER.debug("**** GET LOGIN *******");
        LOGGER.debug("***************");
        ModelAndView model=new ModelAndView("login");
        model.addObject("loginBean",loginBean);
        return model;
        */
        return "login";
    }
}   