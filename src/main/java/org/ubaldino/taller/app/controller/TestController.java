package org.ubaldino.taller.app.controller;

import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ubaldino.taller.app.service.UserService;

/**
  * @author ubaldino
*/
@Controller
public class TestController {
    
    @Autowired private UserService userService;
    
    @GetMapping("/test")
    public @ResponseBody  List<Map<String,Object>> userForm() {
           
        if (!Base.hasConnection()) {
            Base.open();
        }
 
        
        userService.getUser("maria").getRoles().forEach((x)->{
            System.out.println(x.getNombre());
        });
        
        return userService.getAll();
    }
}

