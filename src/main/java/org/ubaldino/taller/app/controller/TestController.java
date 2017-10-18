package org.ubaldino.taller.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.javalite.activejdbc.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ubaldino.taller.app.service.MenuService;
import org.ubaldino.taller.app.service.ProfileService;
import org.ubaldino.taller.app.service.RoleService;
import org.ubaldino.taller.app.service.UserService;

/**
  * @author ubaldino
*/
@Controller
public class TestController {
    
    @Autowired private UserService userService;
    @Autowired private ProfileService profileService;
    @Autowired private RoleService roleService;
    @Autowired private MenuService menuService;
    
    @GetMapping("/test")
    public @ResponseBody  List<Map<String,Object>> userForm() throws SQLException {
           
        if (!Base.hasConnection()) {
            Base.open();
        }
 
        
        userService.get("maria").getRoles().forEach((x)->{
            System.out.println(x.getNombre());
        });
        /*
        PreparedStatement ps = Base.startBatch("insert into people (NAME, LAST_NAME, DOB) values(?, ?, ?)");
        Base.addBatch(ps, "Mic", "Jagger", "1962-01-01");
        Base.addBatch(ps, "Marilyn", "Monroe", "1932-01-01");
        Base.executeBatch(ps);
        ps.close();
        */
        return menuService.getAll();
    }
}

