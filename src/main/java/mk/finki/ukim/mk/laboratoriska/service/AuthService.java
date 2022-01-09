package mk.finki.ukim.mk.laboratoriska.service;


import mk.finki.ukim.mk.laboratoriska.model.User;

public interface AuthService {
    User login(String username,String password);
    User register(String username,String password,String repeatPassword);
}
