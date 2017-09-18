package org.ubaldino.taller.app.controller;

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
    
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView getUserListing() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
