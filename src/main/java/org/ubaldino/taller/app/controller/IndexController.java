package org.ubaldino.taller.app.controller;

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
    
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
 
    /*
    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public ModelAndView getUserListing() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    */
    
    /**
      * This method will list all existing users.
     * @param request
     * @param response
     * @param auth
     * @return 
    */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response,Authentication auth) {
        LOGGER.debug("****************************************");
        LOGGER.debug("::INDEX::"); 
        LOGGER.debug("User: "+auth.getName());
        LOGGER.debug("Auth: "+auth.isAuthenticated());
        
        auth.getAuthorities().forEach((t) -> {
            LOGGER.debug(t.getAuthority() );
        });
        
        LOGGER.debug("****************************************");
        /*
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        */
        
        
        //User user=userDetails.getUser();
        ModelAndView mav = new ModelAndView();
        //mav.addObject("user", user.getLogin());
        mav.setViewName("index");
        return mav;
    }
}
