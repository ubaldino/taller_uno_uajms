package org.ubaldino.taller.app.controller;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.ubaldino.taller.app.service.RoleService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
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
        model.addAttribute("roles",roleService.getAll());
        return "roles/index";
    }
    
    @PostMapping("/roles/store")
    public String store(WebRequest request) {
        roleService.create(request);
        return "redirect:/roles";
    }
    
    
    @PostMapping("/roles/{id}/update")
    public String update(@PathVariable("id") Long roleId,WebRequest request) {
        roleService.modify(request,roleId);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/{id}/enable")
    public String enable(@PathVariable("id") Long roleId) {
        roleService.enable(roleId);
        return "redirect:/roles";
    }
    
    @PostMapping("/roles/{id}/disable")
    public String disable(@PathVariable("id") Long roleId) {
        roleService.disable(roleId);
        return "redirect:/roles ";
    }
    
    @RequestMapping(value="/api/roles/single",method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiRolesSingle() {
        return roleService.getAllSingle();
    }
    
}
