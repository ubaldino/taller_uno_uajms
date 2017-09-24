package org.ubaldino.taller.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ubaldino.taller.app.security.LoginBean;

/**
 * @author ubaldino
 */
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean){
        
        LOGGER.debug("***************");
        LOGGER.debug("**** GET LOGIN *******");
        LOGGER.debug("***************");
        ModelAndView model=new ModelAndView("login");
        model.addObject("loginBean",loginBean);
        return model;
    }
}   