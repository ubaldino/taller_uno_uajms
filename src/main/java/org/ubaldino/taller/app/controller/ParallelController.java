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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.ubaldino.taller.app.service.ParallelService;
/**
 *
 * @author ubaldino
 */
@Controller
public class ParallelController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private ParallelService parallelService;
    
    @GetMapping("/paralelos")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        return "parallels/index";
    }
    
    @PostMapping("/parallels/store")
    public String store(WebRequest request) {
        parallelService.create(request);
        return "redirect:/paralelos";
    }
    
    @PostMapping("/parallels/{id}/update")
    public String update(@PathVariable("id") Long parallelId,WebRequest request) {
        parallelService.modify(request,parallelId);
        return "redirect:/paralelos";
    }
    
    @PostMapping("/parallels/{id}/enable")
    public String enable(@PathVariable("id") Long parallelId) {
        parallelService.enable(parallelId);
        return "redirect:/paralelos";
    }
    
    @PostMapping("/parallels/{id}/disable")
    public String disable(@PathVariable("id") Long parallelId) {
        parallelService.disable(parallelId);
        return "redirect:/paralelos ";
    }
    
    @RequestMapping(value="/api/parallels/single",method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiParallelsSingle() {
        return parallelService.getAllSingle();
    }
}