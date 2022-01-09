package mk.finki.ukim.mk.laboratoriska.service;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Order> listAllOrdersInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addOrderToShoppingCart(String username,Long orderId);

}
