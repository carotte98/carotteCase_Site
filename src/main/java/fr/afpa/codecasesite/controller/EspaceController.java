package fr.afpa.codecasesite.controller;

import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * EspaceController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 14/04/2026
 */
@Controller
public class EspaceController {

    @Autowired
    private UserService userService;

    @GetMapping("/espaceUser")
    public String login(@RequestParam String userMail, Model model) {
        User user = userService.getUserByMail(userMail);
        model.addAttribute("user", user);

        return "userSpace";
    }

    @PostMapping("/deleteUser")
    public ModelAndView deleteUser(@ModelAttribute("user") User user) {
        User realUser = userService.getUserByMail(user.getEmailUser());
        userService.deleteUser(realUser.getIdUser());

        return new ModelAndView("redirect:/");
    }

    @PostMapping("/saveUser")
    public ModelAndView saveUser(@ModelAttribute("user") User user) {
        User realUser = userService.getUserByMail(user.getEmailUser());

        realUser.setEmailUser(user.getEmailUser());
        realUser.setPasswordUser(user.getPasswordUser());
        realUser.setPseudoUser(user.getPseudoUser());
        realUser.setAvatarUser(user.getAvatarUser());

        userService.saveUser(realUser);

        return new ModelAndView("redirect:/");
    }


}
