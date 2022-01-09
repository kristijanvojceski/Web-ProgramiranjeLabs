package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.repository.jpa.OrderRepository;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, User user) {
      return this.orderRepository.save(new Order(balloonColor,balloonSize,user));
    }

    @Override
    public List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }
}
