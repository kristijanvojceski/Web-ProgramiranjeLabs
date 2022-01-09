package mk.finki.ukim.mk.laboratoriska.repository.impl;

import mk.finki.ukim.mk.laboratoriska.bootstrap.DataHolder;
import mk.finki.ukim.mk.laboratoriska.model.ShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class InMemoryShoppingCartRepository {

    public Optional<ShoppingCart> findById(Long id){
        return DataHolder.shoppingCarts.stream().filter(r->r.getId().equals(id)).findFirst();
    }
    public Optional<ShoppingCart> findByUsername(String username){
        return DataHolder.shoppingCarts.stream().filter(r->r.getUser().getUsername().equals(username)).findFirst();
    }
    public ShoppingCart save(ShoppingCart shoppingCart){
        DataHolder.shoppingCarts.removeIf(r->r.getUser().getUsername().equals(shoppingCart.getUser().getUsername()));
        DataHolder.shoppingCarts.add(shoppingCart);
        return shoppingCart;
    }

}
