package fr.afpa.codecasesite.controller;

import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 09/04/2026
 */
@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        Iterable<User> users = userService.getUsers();

        return users.toString();
    }
}
