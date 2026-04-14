package fr.afpa.codecasesite.repository;

import fr.afpa.codecasesite.config.CustomProperties;
import fr.afpa.codecasesite.model.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * <h1>TagRepository</h1>
 * <hr>
 * <p> Repository qui fait le lien entre l'api et la webapp de Tag
 * </p>
 *
 * @author loicrichard
 * @version 0.0.1
 * @since 2026/04/13
 */

@Slf4j
@Component
public class TagRepository {
    /**
     * Les propriétés customs
     */

    @Autowired
    private CustomProperties props;

    /**
     * Méthode getTags
     * <i> de TagRepository</i>
     * <hr>
     * <p>Renvoie tous les tags en BDD</p>
     * @return un Iterable de Tag
     */

    public Iterable<Tag> getTags() {
        String BASE_API_URL = props.getApiUrl();
        String getTagsUrl = BASE_API_URL + "/tags";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Tag>> response = restTemplate.exchange (
                getTagsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        log.debug("Get tags " + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Méthode getTag
     * <i>de TagRepository</i>
     * <hr>
     * <p>Renvoi un tag en fonction de son id</p>
     * @param id l'id du Tag cherché
     * @return le tag
     */

    public Tag getTag(Integer id) {
        String BASE_API_URL = props.getApiUrl();
        String getTagUrl = BASE_API_URL + "/tag/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Tag> response = restTemplate.exchange(
                getTagUrl,
                HttpMethod.GET,
                null,
                Tag.class
        );

        log.debug("Get tag " + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Méthode createTag
     *
     * <i>de TagRepository</i>
     * <hr>
     * <p>Renvoie le tag une fois créé dans la BDD</p>
     * @param tag le tag à créer
     * @return le tag créé
     */

    public Tag createTag(Tag tag) {
        String BASE_API_URL = props.getApiUrl();
        String createTagUrl = BASE_API_URL + "/tag";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Tag> request = new HttpEntity<>(tag);
        ResponseEntity<Tag> response = restTemplate.exchange(
                createTagUrl,
                HttpMethod.POST,
                request,
                Tag.class
        );
        log.debug("Create tag " + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Méthode UpdateTag
     *
     * <i>de TagRepository</i>
     * <hr>
     * <p>Renvoie à la BDD un tag à mettre à jour et renvoie le tag</p>
     * @param tag le tag mise à jour
     * @return le tag mis à jour si réussi
     */
    public Tag updateTag(Tag tag) {
        String BASE_API_URL = props.getApiUrl();
        String updateTagUrl = BASE_API_URL + "/tag" + tag.getIdTag();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Tag> request = new HttpEntity<>(tag);
        ResponseEntity<Tag> reponse = restTemplate.exchange(
                updateTagUrl,
                HttpMethod.PUT,
                request,
                Tag.class
        );
        log.debug("Update tag " + reponse.getStatusCode());
        return reponse.getBody();

}

/**
 * Méthode deletePst
 *
 * <i>de TagRepository</i>
 * <hr>
 * <p>Supprime le tag avec l'id donné, ne renvoie rien</p>
 * @param id l'id du tag à supprimer
 */
public void deleteTag(Integer id) {
        String BASE_API_URL = props.getApiUrl();
        String getTagUrl = BASE_API_URL + "/tag/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Tag> response = restTemplate.exchange(
                getTagUrl,
                HttpMethod.DELETE,
                null,
                Tag.class
        );
        log.debug("Delete tag " + response.getStatusCode());
}


}
