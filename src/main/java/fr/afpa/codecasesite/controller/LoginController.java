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
 * LoginController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 14/04/2026
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping("/loginUser")
    public ModelAndView loginUser(@ModelAttribute("user") User user){

        try{
            User checker = userService.getUserByMail(user.getEmailUser());


            if(checker != null){
                if (checker.getPasswordUser().equals(user.getPasswordUser())){
                    return new ModelAndView("redirect:/espaceUser?userMail=" + checker.getEmailUser());
                }
            }
        }catch (ResponseStatusException rx){
            return new ModelAndView("redirect:/login");

        }

        return new ModelAndView("redirect:/login");
    }
}
