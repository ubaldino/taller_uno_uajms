package org.ubaldino.taller.app.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.logging.Level;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.ubaldino.taller.app.model.Data;
import org.ubaldino.taller.app.model.Profile;
import org.ubaldino.taller.app.model.User;
import org.ubaldino.taller.app.security.AuthUser;
import org.ubaldino.taller.app.service.DataService;
import org.ubaldino.taller.app.service.DateService;
import org.ubaldino.taller.app.service.ProfileService;
import org.ubaldino.taller.app.service.UserService;

/**
 * @author Ubaldino Zurita
 */
@Controller
public class UserController {
    
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private UserService userService;
    @Autowired private ProfileService profileService;
    @Autowired private DataService dataService;
    @Autowired private ServletContext context;
    @Autowired private DateService dateService;
    
    @GetMapping("/dashboard")
    public String dashboard(Locale locale, Model model,Authentication auth) {
        AuthUser authUser = (AuthUser) auth.getPrincipal();
        model.addAttribute("auth",auth);
       
        
        LOGGER.debug( "++++++++++++++++++++++++++++++++++++88888888++++++++++++++++++++++++++++++++++++" );
        //LOGGER.debug( authUser.getProfile().toString() );
        LOGGER.debug( "++++++++++++++++++++++++++++++++++++%%%%%%%%%++++++++++++++++++++++++++++++++++++" );
        
        model.addAttribute("date",dateService.getCurrentDate());
        return "dashboard";
    }
    
    /*
        GET   /users  index
    */
    @GetMapping("/users")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth", auth);
       
        //2017-10-19
        
        
        model.addAttribute("profiles", profileService.list());
        model.addAttribute("date",dateService.getCurrentDate());
        return "users";
    }
    
    @PostMapping("/users")
    public String store(@RequestParam("foto") MultipartFile foto,WebRequest request, Model model) {
        
        String photo_name,photoLocation;
        if (foto.isEmpty())
            photo_name="user_default.png";
        else{
            photo_name=request.getParameter("nombre").replace(" ","")+"_"+foto.getOriginalFilename();
            photoLocation="public"+File.separator+"uploads"+File.separator+photo_name;
            try {
                Files.write(Paths.get(context.getRealPath(photoLocation)),foto.getBytes());
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Profile profile=new Profile();
        profile.setNombre(request.getParameter("nombre"));
        profile.setAp(request.getParameter("ap"));
        profile.setAm(request.getParameter("am"));
        profile.setGenero(request.getParameter("genero"));
        profile.setFnac(new java.sql.Date(
            dateService.formatDate(request.getParameter("fnac")).getTime()
        ));
        profile.setEcivil(request.getParameter("ecivil"));
        profile.setTipo(request.getParameter("tipo_personal"));
        profile.setFoto(photo_name);
        profileService.save(profile);
        
        if(!request.getParameter("cedula").isEmpty()) {
            System.out.println("ID>>>>> "+profile.getCodp());
            Data data=new Data();
            data.setProfile(profile);
            data.setCedula(request.getParameter("cedula"));
            dataService.save(data);
        }
        
        return "redirect:/users";
    }
    
    /*
        DELETE	/users/{id}	destroy
    */
    @PostMapping("/users/{id}/delete")
    public String destroy(@PathVariable("id") Long userId,Model model,Authentication auth) {
        profileService.delete(userId);
        LOGGER.debug(".................................");
        LOGGER.debug("USER DEL "+userId);
        LOGGER.debug(".................................");
        return "redirect:/users";
    }
    
    /*
        DELETE	/users/{id}	enable
    */
    @PostMapping("/users/{id}/enable")
    public String enable(@PathVariable("id") Long userId,Model model,Authentication auth) {
        profileService.enable(userId);
        LOGGER.debug(".................................");
        LOGGER.debug("USER DEL "+userId);
        LOGGER.debug(".................................");
        return "redirect:/users";
    }
    
    /*
        DELETE	/users/{id}	disable
    */
    @PostMapping("/users/{id}/disable")
    public String disable(@PathVariable("id") Long userId,Model model,Authentication auth) {
        profileService.disable(userId);
        LOGGER.debug(".................................");
        LOGGER.debug("USER DEL "+userId);
        LOGGER.debug(".................................");
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
    
    
}
