package mk.finki.ukim.mk.laboratoriska.model.exceptions;


public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(Long id){
        super(String.format("Order with id %d was not found",id));
    }

}
