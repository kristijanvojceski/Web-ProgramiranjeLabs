package mk.finki.ukim.mk.laboratoriska.web.controller;

import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.model.Manufacturer;
import mk.finki.ukim.mk.laboratoriska.service.BalloonService;
import mk.finki.ukim.mk.laboratoriska.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonPage(@RequestParam(required = false) String error, Model model){
        if(error!=null&&!error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        model.addAttribute("listBalloons",this.balloonService.listAll());
        return "listBalloons";
    }
    @PostMapping("/add")
    public String saveBalloon(@RequestParam Long id,
                              @RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer){
        this.balloonService.add(name,description,manufacturer);
        return "redirect:/balloons";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.deleteById(id);
        return "redirect:/balloons";
    }
    @GetMapping("/add-balloon")
    public String addBalloonPage(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturers",manufacturers);
        return "add-balloon";
    }
    @GetMapping("/edit-form/{id}")
    public String editBalloonPage(@PathVariable Long id, Model model) {
        if(this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();

            model.addAttribute("manufacturers", manufacturers);

            model.addAttribute("balloon", balloon);
            return "add-balloon";
        }
        return "redirect:/balloons?error=BalloonNotFound";
    }




}
