package fr.afpa.codecasesite.model;

import java.time.LocalDate;

import fr.afpa.codecasesite.types.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * User
 * <i>de fr.afpa.codecasesite.model</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 2026/04/09
 */
@Data
public class User {

  /**
   * Variable id
   */
  private Integer id;

  /**
   * Variable pseudo
   */
  @Size(min = 3, max = 20, message = "Le pseudonyme doit être de 3 à 20 " +
          "caractères")
  private String pseudo;

  /**
   * Variable mdp
   */
  private String mdp;

  /**
   * Variable email
   */
  @Email
  private String email;

  /**
   * Variable role de type Role (Classe à créer)
   */
  Role role;

  /**
   * Variable signInDate
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate signInDate;

  /**
   * Variable lastLogin
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate lastLogin;

  @Max(250)
  private String avatarUser;

  public User(String pseudo, char[] mdp) {
    setPseudo(pseudo);
    setMdp(mdp);
  }

  public User(String pseudo, char[] mdp, String email) {
    setPseudo(pseudo);
    setMdp(mdp);
    setEmail(email);
  }

  public void setMdp(char[] paraMdp){
    this.mdp = paraMdp.toString();
  }

}
