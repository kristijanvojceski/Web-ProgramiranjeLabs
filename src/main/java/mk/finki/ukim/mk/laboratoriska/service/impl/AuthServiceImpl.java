package mk.finki.ukim.mk.laboratoriska.service.impl;

import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.InvalidArgumentException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.UsernameAlreadyExistsException;
import mk.finki.ukim.mk.laboratoriska.repository.jpa.UserRepository;
import mk.finki.ukim.mk.laboratoriska.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if(username==null||username.isEmpty()||password==null||password.isEmpty()){
            throw new InvalidArgumentException();
        }
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User register(String username, String password, String repeatPassword)
    {
        if(username==null||username.isEmpty()||password==null||password.isEmpty())
            throw new InvalidArgumentException();
        if(!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username)!=null)
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,password);
        this.userRepository.deleteByUsername(username);
        return this.userRepository.save(user);
    }
}
