package fr.afpa.codecasesite.controller;

import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

/**
 * SignupController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 13/04/2026
 */
@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());

        return "signup";
    }

    @PostMapping("/createUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user){

        try{
            user.setSignupDateUser(LocalDate.now());
            user.setLastSignInUser(LocalDate.now());
            user.setRole("Admin");

            userService.saveUser(user);
            return new ModelAndView("redirect:/");
        }catch (ResponseStatusException rx){
            return new ModelAndView("redirect:/signup");

        }

    }
}
