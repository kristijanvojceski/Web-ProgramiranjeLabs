package mk.finki.ukim.mk.laboratoriska.model.exceptions;

public class InvalidUserCredentialException extends RuntimeException{

    public InvalidUserCredentialException(){
        super("Invalid user credentials");
    }

}
