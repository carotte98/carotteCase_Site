package fr.afpa.codecasesite.model;

import java.util.List;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * <h1>Model Tag</h1>
 * <hr>
 * <p>classe métier tag</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 08/04/2026
 */

@Data
public class Tag {
  /**
   * Variable ID.
   */
  private Integer idTag;

  /**
   * Variable intitulé
   */
  @Size(min = 3, max = 30, message =
    "Le tag doit avoir un minimum de 3 caractères et un maximum de 30")
    private String intituleTag;

  @Override
  public String toString() {
    return intituleTag;
  }

}
