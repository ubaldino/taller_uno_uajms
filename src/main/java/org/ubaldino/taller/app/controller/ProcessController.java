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
import org.ubaldino.taller.app.service.ProcessService;

/**
 *
 * @author ubaldino
 */
@Controller
public class ProcessController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private ProcessService processService;
    
    @GetMapping("/procesos")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        return "processes/index";
    }
    
    @PostMapping("/processes/store")
    public String store(WebRequest request,Model model) {
        processService.create(request);
        return "redirect:/procesos";
    }
    
    @PostMapping("/processes/{id}/update")
    public String update(@PathVariable("id") Long roleId,WebRequest request) {
        processService.save(request,roleId);
        return "redirect:/procesos";
    }
    
    @PostMapping("/processes/{id}/enable")
    public String enable(Model model,@PathVariable("id") Long procesoId) {
        processService.enable(procesoId);
        return "redirect:/procesos";
    }
    
    @PostMapping("/processes/{id}/disable")
    public String disable(Model model,@PathVariable("id") Long procesoId) {
        processService.disable(procesoId);
        return "redirect:/procesos";
    }
    
    @RequestMapping(value="/api/processes",method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiProcesos() {
        return processService.getAll();
    }
    
    @RequestMapping(value="/api/processes/single",method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiProcessesSingle() {
        return processService.getAllSingle();
    }
    
    
}
