package mk.finki.ukim.mk.laboratoriska.repository.jpa;

import mk.finki.ukim.mk.laboratoriska.model.ShoppingCart;
import mk.finki.ukim.mk.laboratoriska.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

    ShoppingCart findByUser(User user);

}
