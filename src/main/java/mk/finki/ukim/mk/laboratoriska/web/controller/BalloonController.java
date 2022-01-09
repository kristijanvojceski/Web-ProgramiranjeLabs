package mk.finki.ukim.mk.laboratoriska.web.controller;

import mk.finki.ukim.mk.laboratoriska.model.*;
import mk.finki.ukim.mk.laboratoriska.service.BalloonService;
import mk.finki.ukim.mk.laboratoriska.service.ManufacturerService;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import mk.finki.ukim.mk.laboratoriska.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final OrderService orderService;
    private final ShoppingCartService shoppingCartService;

    public BalloonController(BalloonService balloonService,
                             ManufacturerService manufacturerService,
                             OrderService orderService,
                             ShoppingCartService shoppingCartService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.orderService = orderService;
        this.shoppingCartService = shoppingCartService;
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
        if(id==0){
            this.balloonService.add(name,description,manufacturer);
        }
        else{
            this.balloonService.edit(id,name,description,manufacturer);
        }
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
    @PostMapping("/redirectToSize/{name}")
    public void redirectToSize(@PathVariable String name, HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().setAttribute("chosenColor",name);
        response.sendRedirect("/selectBalloon");
    }

    @PostMapping("/selectBalloon")
    public void postSelectBalloon(HttpServletRequest request, HttpServletResponse response)throws IOException {
        User user  = (User) request.getSession().getAttribute("user");
        Order order  = orderService.placeOrder((String)request.getSession().getAttribute("chosenColor")
                ,(String) request.getParameter("size"),user);
        shoppingCartService.addOrderToShoppingCart(user.getUsername(), order.getOrderId());
        response.sendRedirect("/balloons");
    }




}
