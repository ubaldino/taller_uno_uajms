package org.ubaldino.taller.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ubaldino
 */
@Controller
public class ProcesoController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    /*
    @Autowired private ProcesoService procesoService;
    
    @GetMapping("/procesos")
    public String index(Model model,Authentication auth) {
        model.addAttribute("auth",auth);
        model.addAttribute("procesos",procesoService.list());
        return "procesos/index";
    }
    
    @PostMapping("/procesos/store")
    public String store(WebRequest request,Model model) {
        Proceso proceso=new Proceso();
        proceso.setNombre(request.getParameter("nombre"));
        proceso.setEnlace(request.getParameter("enlace"));
        procesoService.save(proceso);
        return "redirect:/procesos";
    }
    
    @PostMapping("/procesos/{id}/update")
    public String update(@PathVariable("id") Long roleId,WebRequest request) {
        Proceso proceso=procesoService.getProceso(roleId);
        proceso.setNombre(request.getParameter("nombre"));
        proceso.setEnlace(request.getParameter("enlace"));
        procesoService.save(proceso);
        return "redirect:/procesos";
    }
    
    @PostMapping("/procesos/{id}/enable")
    public String enable(Model model,@PathVariable("id") Long procesoId) {
        procesoService.enable(procesoId);
        return "redirect:/procesos";
    }
    
    @PostMapping("/procesos/{id}/disable")
    public String disable(Model model,@PathVariable("id") Long procesoId) {
        procesoService.disable(procesoId);
        return "redirect:/procesos";
    }
    */
}
