package org.ubaldino.taller.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.model.Role;
import org.ubaldino.taller.app.service.RoleService;

/**
 *
 * @author ubaldino
 */
@Controller
public class RoleController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private RoleService roleService;
    
    @GetMapping("/roles")
        public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("roles",roleService.list());
        return "roles/index";
    }
    
    @PostMapping("/roles/store")
    public String store(WebRequest request,Model model) {
        Role role=new Role();
        role.setNombre(request.getParameter("nombre"));
        roleService.save(role);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/{id}/update")
    public String update(@PathVariable("id") Long roleId,WebRequest request) {
        Role role=roleService.getRole(roleId);
        role.setNombre(request.getParameter("nombre"));
        roleService.save(role);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/{id}/enable")
    public String enable(Model model,@PathVariable("id") Long roleId) {
        roleService.enable(roleId);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/{id}/disable")
    public String disable(Model model,@PathVariable("id") Long roleId) {
        roleService.disable(roleId);
        return "redirect:/roles ";
    }
}
