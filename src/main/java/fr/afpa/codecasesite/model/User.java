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
  private Integer idUser;

  /**
   * Variable pseudo
   */
  @Size(min = 3, max = 20, message = "Le pseudonyme doit être de 3 à 20 " +
          "caractères")
  private String pseudoUser;

  /**
   * Variable mdp
   */
  private String passwordUser;

  /**
   * Variable email
   */
  @Email
  private String emailUser;

  /**
   * Variable role de type Role (Classe à créer)
   */
  Role role;

  /**
   * Variable signInDate
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate signupDateUser;

  /**
   * Variable lastLogin
   */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate lastSignInUser;

  /**
   * Variable avatarUser
   */
  @Max(250)
  private String avatarUser;

  /**
   * Méthode setMdp (char[])
   *<i>de User</i>
   *<hr>
   *<p>Setter pour le mot de passe si venu d'un input, non hash</p>
   *
   * @param paraMdp venu d'un input
   */
  public void setMdp(char[] paraMdp){
    this.passwordUser = paraMdp.toString();
  }

  /**
   * Méthode setMdp (String)
   *<i>de User</i>
   *<hr>
   *<p>Setter pour le mot de passe si venu d'une BDD, hashé</p>
   *
   * @param paraMdp venu d'une BDD
   */
  public void setMdp(String paraMdp){
    this.passwordUser = paraMdp;
  }

  /**
   * Méthode setRole
   *<i>de User</i>
   *<hr>
   *<p>Prends le String venu de la BDD et en fait un Role</p>
   *
   * @param paraRole Le rôle sous forme de String
   */
  public void setRole(String paraRole){
    if (paraRole.equals("Admin")){
      this.role = Role.ADMIN;
    }else{
      this.role = Role.USER;
    }
  }
}
