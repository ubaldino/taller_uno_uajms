package org.ubaldino.taller.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    /*
    @GetMapping("/menus")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("menus",menuService.list());
        return "menus/index";
    }
    
    @PostMapping("/menus/store")
    public String store(WebRequest request,Model model) {
        Menu menu=new Menu();
        menu.setNombre(request.getParameter("nombre"));
        menuService.save(menu);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/update")
    public String update(@PathVariable("id") Long menuId,WebRequest request) {
        Menu menu=menuService.getMenu(menuId);
        menu.setNombre(request.getParameter("nombre"));
        menuService.save(menu);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/enable")
    public String enable(Model model,@PathVariable("id") Long menuId) {
        menuService.enable(menuId);
        return "redirect:/menus";
    }
    
    @PostMapping("/menus/{id}/disable")
    public String disable(Model model,@PathVariable("id") Long menuId) {
        menuService.disable(menuId);
        return "redirect:/menus ";
    }
    
    @GetMapping("/menus/procesos")
    public String procesos(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("menus",menuService.list());
        model.addAttribute("procesos",procesoService.list());
        return "menus/procesos";
    }
    
    @RequestMapping(value="/tmenus", method = RequestMethod.GET)
    public @ResponseBody List<Menu> getShopInJSON() {
        return menuService.list();
    }
    
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
