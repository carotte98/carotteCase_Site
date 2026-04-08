package fr.afpa.codecasesite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Tag
 * <i>de fr.afpa.codecasesite.model</i>
 * <hr>
 * <p></p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 08/04/2026
 */

@Entity
@Data
public class Tag {

  @Id
  private int id;
}
