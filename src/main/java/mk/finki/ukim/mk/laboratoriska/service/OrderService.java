package mk.finki.ukim.mk.laboratoriska.service;

import mk.finki.ukim.mk.laboratoriska.model.Order;

import java.util.List;

public interface OrderService {

    Order placeOrder(String balloonColor,String balloonSize,String clientName,String address);
    List<Order> getOrders();

}
