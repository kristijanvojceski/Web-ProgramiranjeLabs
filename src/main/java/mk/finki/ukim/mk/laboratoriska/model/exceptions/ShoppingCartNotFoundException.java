package mk.finki.ukim.mk.laboratoriska.model.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{

    public ShoppingCartNotFoundException(Long id){
        super(String.format("Shopping cart with %d id was not found",id));
    }

}
