package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.model.ShoppingCart;
import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.OrderAlreadyInShoppingCartException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.OrderNotFoundException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.ShoppingCartNotFoundException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.UserNotFoundException;
import mk.finki.ukim.mk.laboratoriska.repository.jpa.ShoppingCartRepository;
import mk.finki.ukim.mk.laboratoriska.repository.jpa.UserRepository;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import mk.finki.ukim.mk.laboratoriska.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;

    public ShoppingCartImpl(ShoppingCartRepository shoppingCartRepository,
                            UserRepository userRepository, OrderService orderService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
    }

    @Override
    public List<Order> listAllOrdersInShoppingCart(Long cartId) {
        if(!this.shoppingCartRepository.findById(cartId).isPresent())
            throw new ShoppingCartNotFoundException(cartId);
        return this.shoppingCartRepository.findById(cartId).get().getOrders();
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String username) {
        User user = this.userRepository.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException(username);
        }
        ShoppingCart sc = this.shoppingCartRepository.findByUser(user);
        if(sc == null){
            return shoppingCartRepository.save(new ShoppingCart(user));
        }
        else{
            return sc;
        }
    }

    @Override
    public ShoppingCart addOrderToShoppingCart(String username, Long orderId) {
       ShoppingCart shoppingCart = this.getActiveShoppingCart(username);
       Order order = this.orderService.findById(orderId)
               .orElseThrow(()-> new OrderNotFoundException(orderId));
       if(shoppingCart.getOrders().stream().filter(r->r.getOrderId().equals(orderId)).collect(Collectors.toList()).size()>0)
           throw new OrderAlreadyInShoppingCartException(orderId,username);
       shoppingCart.getOrders().add(order);
       return this.shoppingCartRepository.save(shoppingCart);
    }
}
