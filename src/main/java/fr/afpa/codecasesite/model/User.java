package fr.afpa.codecasesite.model;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

/**
 * User
 * <i>de fr.afpa.codecasesite.model</i>
 * <hr>
 * <p></p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 07/04/2026
 */

@Data
public class User implements Serializable {

  /**
   * Variable id
   */
  private Integer id;

  /**
   * Variable pseudo
   */
  private String pseudo;

  /**
   * Variable mdp
   */
  private String mdp;

  /**
   * Variable email
   */
  private String email;

  /**
   * Variable role de type Role (Classe à créer)
   */
//  Role role;

  /**
   * Variable signInDate
   */
  private LocalDate signInDate;

  /**
   * Variable lastLogin
   */
  private LocalDate lastLogin;

  public User(String pseudo, String mdp) {
    setPseudo(pseudo);
    setMdp(mdp);
  }

  public User(String pseudo, String mdp, String email) {
    setPseudo(pseudo);
    setMdp(mdp);
    setEmail(email);
  }

}
