package fr.afpa.codecasesite.controller;

import fr.afpa.codecasesite.model.Post;
import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.service.PostService;
import fr.afpa.codecasesite.service.UserService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * PostController
 * <i>de fr.afpa.codecasesite.controller</i>
 * <hr>
 * <p></p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/14
 */

@Controller
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping("/creationPost")
  public String formulaire(Model model) {
    model.addAttribute("post", new Post());
    model.addAttribute("tags", tagService.getTags);
    return "creationPost";
  }

  @PostMapping("/createPost")
  public ModelAndView savePost(@ModelAttribute("post") Post post){

    post.setIdUser(1);
    post.setDateCreation(LocalDate.now());


    postService.savePost(post);
    return new ModelAndView("redirect:/");
  }
}
