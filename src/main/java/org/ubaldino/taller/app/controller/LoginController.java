package org.ubaldino.taller.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ubaldino.taller.app.security.LoginBean;

/**
 * @author ubaldino
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String displayLogin(Model model, LoginBean loginBean){
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