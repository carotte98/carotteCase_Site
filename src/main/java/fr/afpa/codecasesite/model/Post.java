package fr.afpa.codecasesite.model;

import fr.afpa.codecasesite.service.TagService;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Post
 * <i>de fr.afpa.codecasesite.model</i>
 * <hr>
 * <p>Classe métier Post</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/08
 */

@Data
public class Post {

  /**
   * Variable id.
   */
  private Integer idPost;

  /**
   * Variable titre.
   */
  @Size(min = 3, max = 100,
      message = "Le titre doit être renseigné et"
          + " être entre 3 et 100 caractères")
  private String titrePost;

  /**
   * Variable description.
   */
  @Size(max = 250,
      message = "La description doit contenir au maximum 250 caractères")
  private String descriptionPost;

  /**
   * Variable contenu.
   */
  @NotEmpty(message = "Le post ne doit pas être vide")
  private String contenuPost;

  /**
   * Variable userId.
   */
  private User idUser;

  /**
   * Variable language de type Tag.
   */
  private Tag idTag;

  /**
   * Variable tagCustom, dans une Arraylist de type Tag.
   */
//  Set<Tag> tagCustom;

  /**
   * Variable creationPost.
   */
  private LocalDate dateCreation;

}
