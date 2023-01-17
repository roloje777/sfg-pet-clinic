package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
  Note the Controller uses a Service to get the information
  This is recommended by the DDD methodology
 */
@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets","/vets/index","/vets/index.html"})
    String listVets(Model model){
        // returns a Set<Vet> that the model will use
        model.addAttribute("vets", vetService.findAll());
        /* linked to the Thymeleaf generated HTML
           which is the view part of MVC
         */
        return "vets/index";
    }
}
