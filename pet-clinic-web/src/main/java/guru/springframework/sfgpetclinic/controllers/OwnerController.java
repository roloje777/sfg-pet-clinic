package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        //This class merely holds both to make it possible for a controller to return both model
        // and view in a single return value.
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

}

