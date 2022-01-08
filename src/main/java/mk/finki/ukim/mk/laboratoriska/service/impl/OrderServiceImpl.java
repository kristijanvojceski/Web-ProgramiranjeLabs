package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import mk.finki.ukim.mk.laboratoriska.repository.InMemoryBalloonRepository;
import mk.finki.ukim.mk.laboratoriska.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final InMemoryBalloonRepository balloonRepository;

    public OrderServiceImpl(InMemoryBalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String balloonSize, String clientName, String address) {
        return balloonRepository.placeOrder(clientName,address,balloonColor,balloonSize);
    }

    @Override
    public List<Order> getOrders() {
        return balloonRepository.getOrders();
    }
}
