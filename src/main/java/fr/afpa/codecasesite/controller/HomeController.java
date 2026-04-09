package fr.afpa.codecasesite.controller;

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

    @GetMapping("/")
    public String home() {
        return "App is running 👍";
    }
}
