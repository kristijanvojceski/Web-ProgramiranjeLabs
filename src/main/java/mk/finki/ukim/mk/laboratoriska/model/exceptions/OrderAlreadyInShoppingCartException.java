package mk.finki.ukim.mk.laboratoriska.model.exceptions;

public class OrderAlreadyInShoppingCartException extends RuntimeException{

    public OrderAlreadyInShoppingCartException(Long id,String username){
        super(String.format("Order with id %d already in shopping cart for user %s",id,username));
    }

}
