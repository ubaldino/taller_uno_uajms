package org.ubaldino.taller.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author ubaldino
 */
@Controller
public class IndexController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
 
    /**
      * This method will list all existing users.
      * @param request
      * @param response
      * @param auth
      * @return 
    */
    @RequestMapping(value={"/"},method=RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,Authentication auth) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("auth",auth);
        mav.addObject("date",(String)new SimpleDateFormat("dd/MMMM/yyyy").format(new Date()));
        mav.setViewName("index");
        return mav;
    }
}
