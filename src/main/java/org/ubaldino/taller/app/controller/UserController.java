package org.ubaldino.taller.app.controller;

import java.util.Locale;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.ubaldino.taller.app.model.User;
import org.ubaldino.taller.app.service.UserServiceInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Ubaldino Zurita
 */
@Controller
public class UserController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private UserServiceInterface userService;
    
    @GetMapping("/dashboard")
    public String dashboard(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        return "dashboard";
    }
    
    /*
        GET   /users  index
    */
    @GetMapping("/users")
    public String index(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    
    /*
        GET	/users/create	create
    */
    /*
    @GetMapping("/users/create")
    public String create(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    /*
    /*
        POST	/users	store
    */
    @PostMapping("/users")
    public String store(@ModelAttribute("user") @Valid User user,BindingResult result,Model model){
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "userForm";
        }
        userService.save(user);
        return "redirect:/users";
    }
    
    /*
        GET	/users/{id}	show
    
    @GetMapping("/users/{id}")
    public String show(@PathVariable("id") Integer userId,Locale locale, Model model,Authentication auth) {
        LOGGER.debug("__________________________");
        LOGGER.debug( ">> "+userId.longValue() );
        LOGGER.debug("__________________________");
        model.addAttribute("auth", auth);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.list());
        return "userForm";
    }
    */
    
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
    /*
        DELETE	/users/{id}	destroy
    */
    @PostMapping("/users/{id}/delete")
    public String destroy(@PathVariable("id") String userId,Model model,Authentication auth) {
        LOGGER.debug(".................................");
        LOGGER.debug("USER DEL "+userId);
        LOGGER.debug(".................................");
        return "redirect:/users";
    }
    
}
