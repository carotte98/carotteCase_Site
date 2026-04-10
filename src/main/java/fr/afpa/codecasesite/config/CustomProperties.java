package fr.afpa.codecasesite.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * CustomProperties
 * <i>de fr.afpa.codecasesite.config</i>
 * <hr>
 * <p>Contient les propriétés Customs</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 09/04/2026
 */
@Data
@ConfigurationProperties(prefix = "fr.afpa.codecasesite.appweb")
public class CustomProperties {

    /**
     * L'url vers l'api
     */
    private String apiUrl;
}
