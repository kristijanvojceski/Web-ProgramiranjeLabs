package mk.finki.ukim.mk.laboratoriska.web.controller;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/userOrder")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping
    public String getOrderPage(@RequestParam(required = false) String error, Model model){
        if(error!=null&&!error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Order> orders = this.orderService.getOrders();
        model.addAttribute("orders",orders);
        return "usersOrder";
    }
}
