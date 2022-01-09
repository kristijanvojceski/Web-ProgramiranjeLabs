package mk.finki.ukim.mk.laboratoriska.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(String username){
        super(String.format("User with %s username already exists",username));
    }

}
