package org.ubaldino.taller.app.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Menu;
import org.ubaldino.taller.app.service.MenuService;
import org.ubaldino.taller.app.service.ProcesoService;
import org.ubaldino.taller.app.service.ProfileService;
import org.ubaldino.taller.app.service.UserService;

/**
 *
 * @author ubaldino
 */
@Controller
//@RequestMapping("/menus")
public class MenuController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private MenuService menuService;
    @Autowired private ProcesoService procesoService;
    @Autowired private UserService userService;
    @Autowired private ProfileService profileService;
    
    @GetMapping("/menus")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("menus",menuService.getAll());
        return "menus/index";
    }
    
    @PostMapping("/menus/store")
    public String store(WebRequest request) {
        menuService.create(request);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/update")
    public String update(@PathVariable("id") Long menuId,WebRequest request) {
        menuService.modify(request, menuId);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/enable")
    public String enable(@PathVariable("id") Long menuId) {
        menuService.enable(menuId);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/disable")
    public String disable(@PathVariable("id") Long menuId) {
        menuService.disable(menuId);
        return "redirect:/menus ";
    }
    
    @GetMapping("/menus/procesos")
    public String procesos(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("menus",menuService.getAll());
        model.addAttribute("procesos",procesoService.getAll());
        return "menus/procesos";
    }
    
    @RequestMapping(value="/menus/api", method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiProcesos() {
        return menuService.getAll();
    }
    /*
    @RequestMapping(value="/tusers", method = RequestMethod.GET)
    public String getShopInJSON2() {
        System.out.println( "¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        for( User p: userService.list() ){
            System.out.println( p.toString() );
            
        }
        System.out.println( "?????????????????????????????");
        return "test";
    }
    
    @RequestMapping(value="/tprofiles", method = RequestMethod.GET)
    //@ResponseBody
    public String getShopInJSON3() {
        System.out.println( "¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿");
        for( Profile p: profileService.list() ){
            System.out.println( p.toString() );
            
        }
        System.out.println( "?????????????????????????????");
        return "test";
 
    }
    */
    
}
