package mk.finki.ukim.mk.laboratoriska.repository.jpa;

import mk.finki.ukim.mk.laboratoriska.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
