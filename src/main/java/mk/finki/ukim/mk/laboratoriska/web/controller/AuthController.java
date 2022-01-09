package mk.finki.ukim.mk.laboratoriska.web.controller;

import mk.finki.ukim.mk.laboratoriska.model.User;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.InvalidArgumentException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.InvalidUserCredentialException;
import mk.finki.ukim.mk.laboratoriska.model.exceptions.PasswordsDoNotMatchException;
import mk.finki.ukim.mk.laboratoriska.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model){
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("user",user);
            return "redirect:/balloons";
        }catch (InvalidUserCredentialException exception){
            model.addAttribute("hasError",true);
            model.addAttribute("error",exception.getMessage());
            return "login";
        }
    }
    @GetMapping("/register")
    public String getRegisterPage(@RequestParam(required = false) String error,Model model){
        if(error!=null&&!error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username,@RequestParam String password,@RequestParam String repeatPassword){
        try{
            this.authService.register(username,password,repeatPassword);
            return "redirect:/login";
        }catch (InvalidArgumentException | PasswordsDoNotMatchException exception){
            return "redirect:/register?error="+exception.getMessage();
        }
    }
}
