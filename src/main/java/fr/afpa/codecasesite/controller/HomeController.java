package fr.afpa.codecasesite.controller;

import fr.afpa.codecasesite.service.PostService;
import fr.afpa.codecasesite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/09
 */
@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String home() {
//        Iterable<User> users = userService.getUsers();

        return "creationPost";
    }
}
