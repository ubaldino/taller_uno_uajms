package org.ubaldino.taller.app.controller;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.ubaldino.taller.app.dao.UserDao;
import org.ubaldino.taller.app.security.LoginBean;

/**
 * @author ubaldino
 */
@Controller
public class LoginController {
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, LoginBean loginBean){
        ModelAndView model=new ModelAndView("login");
        model.addObject("loginBean",loginBean);
        return model;
    }
    
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean){
        ModelAndView model= null;
        System.out.println("-----------------1-----------");
        System.out.println(loginBean.getLogin());
        System.out.println(loginBean.getPassword());
        System.out.println("-----------------111-----------");
        //boolean isValidUser=this.loginDelegate.isValidUser(loginBean.getLogin(),loginBean.getPassword());
        //UserDao userDao=new UserDao();
        System.out.println("-----------------2-----------");
        
        /*
        if(isValidUser){
        System.out.println("User Login Successful");
        request.setAttribute("loggedInUser", loginBean.getLogin());
        model = new ModelAndView("welcome");
        }
        else{
        model = new ModelAndView("login");
        model.addObject("loginBean", loginBean);
        request.setAttribute("message", "Invalid credentials!!");
        }
        */
        return model;
    }
}   