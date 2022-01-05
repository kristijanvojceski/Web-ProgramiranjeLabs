package mk.finki.ukim.mk.laboratoriska.repository;

import mk.finki.ukim.mk.laboratoriska.bootstrap.DataHolder;
import mk.finki.ukim.mk.laboratoriska.model.Balloon;
import mk.finki.ukim.mk.laboratoriska.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryBalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream()
                .filter(r->r.getName().contains(text)||r.getDescription().contains(text))
                .collect(Collectors.toList());
    }
    public Order placeOrder(String clientName,String clientAddress,String balloonColor,String balloonSize){
        Order order = new Order(balloonColor,balloonSize,clientName,clientAddress);
        order.setOrderId((long)DataHolder.orderList.size());
        DataHolder.orderList.add(order);
        return order;
    }
    public List<Order> getOrders(){
        return DataHolder.orderList;
    }

}
