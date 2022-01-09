package mk.finki.ukim.mk.laboratoriska.service;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.model.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(String balloonColor, String balloonSize, User user);
    List<Order> getOrders();
    Optional<Order> findById(Long id);

}
