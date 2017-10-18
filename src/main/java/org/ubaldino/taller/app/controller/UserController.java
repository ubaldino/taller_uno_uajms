package org.ubaldino.taller.app.controller;


import java.util.Locale;
import javax.servlet.ServletContext;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.ubaldino.taller.app.service.DateService;
import org.ubaldino.taller.app.service.ProfileService;
import org.ubaldino.taller.app.service.UserService;

/**
 * @author Ubaldino Zurita
 */
@Controller
public class UserController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired private UserService userService;
    @Autowired private ProfileService profileService;
    @Autowired private ServletContext context;
    @Autowired private DateService dateService;
    
    @GetMapping("/dashboard")
    public String dashboard(Locale locale, Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        //AuthUser authUser = (AuthUser) auth.getPrincipal();
        model.addAttribute("auth",auth);
        model.addAttribute("date",dateService.getCurrentDate());
        return "users/dashboard";
    }
    
    /*
        GET   /users  index
    */
    @GetMapping("/users")
    public String index(Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        //2017-10-19
        model.addAttribute("auth", auth)    ;
        model.addAttribute("profiles", profileService.getAll());
        model.addAttribute("date",dateService.getCurrentDate());
        return "users/index";
    }
    
    
    @PostMapping("/users")
    public String store(@RequestParam("foto") MultipartFile foto,WebRequest request, Model model) {
        if(!Base.hasConnection()) Base.open();
        profileService.save(request,foto);
        return "redirect:/users";
    }
    
    
    /*
        DELETE	/users/{id}	destroy
    
    @PostMapping("/users/{id}/delete")
    public String destroy(@PathVariable("id") Long userId,Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        profileService.delete(userId);
        return "redirect:/users";
    }
    */
    /*
        DELETE	/users/{id}	enable
    */
    @PostMapping("/users/{id}/enable")
    public String enable(@PathVariable("id") Integer userId,Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        profileService.enable(userId);
        return "redirect:/users";
    }
    
    /*
        DELETE	/users/{id} 	disable
    */
    @PostMapping("/users/{id}/disable")
    public String disable(@PathVariable("id") Long userId,Model model,Authentication auth) {
        if(!Base.hasConnection()) Base.open();
        profileService.disable(userId);
        return "redirect:/users";
    }
    
    /*
        /users/25/assign
    */
    @PostMapping("/users/{id}/assign")
    public String loginAssign(@PathVariable("id") Long profileId,Model model,WebRequest request) {
        userService.save(request,profileId);
        return "redirect:/users";
    }
    
    /*
        /users/login/#{profile.codp}/modify
    */
    @PostMapping("/users/login/{id}/modify")
    public String loginModify(@PathVariable("id") Long userId,Model model,WebRequest request) {
        if(!Base.hasConnection()) Base.open();
        userService.modify(request,userId);
        return "redirect:/users";
    }
    
    /*
        GET	/users/{id}	show
    */
    @GetMapping("/users/{id}")
    public String show(@PathVariable("id") Long userId,Locale locale, Model model,Authentication auth) {
        LOGGER.debug("__________________________");
        LOGGER.debug( ">> "+userId.longValue() );
        LOGGER.debug("__________________________");
        model.addAttribute("auth", auth);
        model.addAttribute("user", userService.get(userId));
        return "userForm";
    }
    
    
    /*
        GET	/users/{id}/edit	edit
    */
    /*
    @GetMapping("/users/{id}/edit")
    public String edit(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    */
    
    /*
        PUT/PATCH	/users/{id}	update
    
    @PutMapping("/users/{id}")
    public String update(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    */
    
    
}
