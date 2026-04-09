package fr.afpa.codecasesite.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

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
  private Integer id;

  /**
   * Variable titre.
   */
  @Size(min = 3, max = 100,
      message = "Le titre doit être renseigné et"
          + " être entre 3 et 100 caractères")
  private String titre;

  /**
   * Variable description.
   */
  @Size(max = 250,
      message = "La description doit contenir au maximum 250 caractères")
  private String description;

  /**
   * Variable contenu.
   */
  @NotEmpty(message = "Le post ne doit pas être vide")
  private String contenu;

  /**
   * Variable userId.
   */
  private Integer userId;

  /**
   * Variable language de type Tag.
   */
  private Set<Tag> language;

  /**
   * Variable tagCustom, dans une Arraylist de type Tag.
   */
  Set<Tag> tagCustom;

  /**
   * Variable creationPost.
   */
  private LocalDate creationPost;

}
