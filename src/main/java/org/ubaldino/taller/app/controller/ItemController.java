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
import org.ubaldino.taller.app.service.ItemService;
/**
 *
 * @author ubaldino
 */
@Controller
public class ItemController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired private ItemService itemService;
    
    @GetMapping("/items")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        return "items/index";
    }
    
    @PostMapping("/items/store")
    public String store(WebRequest request) {
        itemService.create(request);
        return "redirect:/items";
    }
    
    @PostMapping("/items/{id}/update")
    public String update(@PathVariable("id") Long itemId,WebRequest request) {
        itemService.modify(request,itemId);
        return "redirect:/items";
    }
    
    @PostMapping("/items/{id}/enable")
    public String enable(@PathVariable("id") Long itemId) {
        itemService.enable(itemId);
        return "redirect:/items";
    }
    
    @PostMapping("/items/{id}/disable")
    public String disable(@PathVariable("id") Long itemId) {
        itemService.disable(itemId);
        return "redirect:/items ";
    }
    
    @RequestMapping(value="/api/items/single",method=RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> apiItemsSingle() {
        return itemService.getAllSingle();
    }
}