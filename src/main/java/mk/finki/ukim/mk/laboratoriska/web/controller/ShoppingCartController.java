package mk.finki.ukim.mk.laboratoriska.web.controller;

import mk.finki.ukim.mk.laboratoriska.model.ShoppingCart;
import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public String getShoppingCartPage(@RequestParam(required = false) String error, HttpServletRequest request, Model model){
        if(error!=null&&!error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        User user = (User) request.getSession().getAttribute("user");
        ShoppingCart shoppingCart  = this.shoppingCartService.getActiveShoppingCart(user.getUsername());
        model.addAttribute("orders",this.shoppingCartService.listAllOrdersInShoppingCart(shoppingCart.getId()));
        return "shopping-cart";
    }
    @PostMapping("/add-order/{id}")
    public String addOrderToShoppingCart(@PathVariable Long id,HttpServletRequest request){
        try{
            User user = (User) request.getSession().getAttribute("user");
            ShoppingCart shoppingCart = this.shoppingCartService.addOrderToShoppingCart(user.getUsername(),id);
            return "redirect:/shopping-cart";
        }catch (RuntimeException exception){
            return "redirect:/shopping-cart?error"+exception.getMessage();
        }
    }

}
