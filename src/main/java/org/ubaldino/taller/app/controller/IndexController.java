package org.ubaldino.taller.app.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
     * @return 
    */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public ModelAndView index() {
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
    /*
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String index(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userList";
        
        return "index";
    }
    */
    
    /**
      * This method returns the principal[user-name] of logged-in user.
    */
    /*
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
             userName = ((UserDetails)principal).getUsername();
        } else {
             userName = principal.toString();
        }
        return userName;
    }
    */
   
}
