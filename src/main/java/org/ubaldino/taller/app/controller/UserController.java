package org.ubaldino.taller.app.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.ubaldino.taller.app.service.DataService;
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
    
    @GetMapping("/dashboard")
    public String dashboard(Locale locale, Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        return "dashboard";
    }
    
    /*
        GET   /users  index
    */
    @GetMapping("/users")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth", auth);
        model.addAttribute("profiles", profileService.list());
        return "users";
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
    public String store(@RequestParam("foto") MultipartFile foto,WebRequest request, Model model) {
        
        String photo_name,photoLocation;
        if (foto.isEmpty()) {
            photo_name="user_default.png";
        }
        else
            photo_name=request.getParameter("nombre").replace(" ","")+"_"+foto.getOriginalFilename();
        photoLocation="public"+File.separator+"uploads"+File.separator+photo_name;
        

        LOGGER.debug( "**************POST PHOTO************************************¿¿¿¿¿" );
        try {
            Files.write(Paths.get(context.getRealPath(photoLocation)),foto.getBytes());
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //"user_default.png"
        LOGGER.debug( "*************************************************************›????" );
        
        Profile profile=new Profile();
        profile.setNombre(request.getParameter("nombre"));
        profile.setAp(request.getParameter("ap"));
        profile.setAm(request.getParameter("am"));
        profile.setGenero(request.getParameter("genero"));
        profile.setFnac(new java.sql.Date(
            this.formatDate(request.getParameter("fnac")).getTime()
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
        
        /*
        if (result.hasErrors()) {
            model.addAttribute("users", userService.list());
            return "users";
        }
        */
        //userService.save(user);
        return "redirect:/users";
        //return "";
    }
   
    private Date formatDate(String userInput) {
        Date date;
        try{
            date=new SimpleDateFormat("yyyy-MMMM-dd").parse(userInput);
        }catch (ParseException e){
            date=new Date();
        }
        return date;
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
