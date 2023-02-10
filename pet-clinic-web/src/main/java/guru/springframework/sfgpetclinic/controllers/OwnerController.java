package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.sfgpetclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

     // controller injected dependency
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @RequestMapping({"","/","/index","index.html"})
    String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notimplemented";
    }

}

