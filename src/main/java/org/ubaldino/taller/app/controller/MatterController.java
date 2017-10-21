package org.ubaldino.taller.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.service.MatterService;
/**
 *
 * @author ubaldino
 */
@Controller
public class MatterController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private MatterService matterService;
    
    @GetMapping("/materias")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("matters",matterService.getAllSingle());
        return "matters/index";
    }
    
    @PostMapping("/materias/store")
    public String store(WebRequest request) {
        matterService.create(request);
        return "redirect:/materias";
    }
    
    
    @PostMapping("/materias/{id}/update")
    public String update(@PathVariable("id") Long matterId,WebRequest request) {
        matterService.modify(request,matterId);
        return "redirect:/materias";
    }
    
    @PostMapping("/materias/{id}/enable")
    public String enable(@PathVariable("id") Long matterId) {
        matterService.enable(matterId);
        return "redirect:/materias";
    }
    
    @PostMapping("/materias/{id}/disable")
    public String disable(@PathVariable("id") Long matterId) {
        matterService.disable(matterId);
        return "redirect:/materias ";
    }
    
}
