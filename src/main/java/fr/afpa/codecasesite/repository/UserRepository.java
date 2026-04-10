package fr.afpa.codecasesite.repository;

import fr.afpa.codecasesite.config.CustomProperties;
import fr.afpa.codecasesite.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * UserRepository
 * <i>de fr.afpa.codecasesite.repository</i>
 * <hr>
 * <p>Repository qui fait le lien entre l'api et la webapp</p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 09/04/2026
 */
@Slf4j
@Component
public class UserRepository {

    /**
     * Les propriétés customs
     */
    @Autowired
    private CustomProperties props;


    /**
     * Méthode getUsers
     *
     *<i>de UserRepository</i>
     *<hr>
     *<p>Renvoie tout les Users en BDD</p>
     * @return un Iterable de User
     */
    public Iterable<User> getUsers(){
        String BASE_API_URL = props.getApiUrl();
        String getPersonsUrl = BASE_API_URL + "/users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
                getPersonsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );

        log.debug("Get Users " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Méthode getUser
     *
     *<i>de UserRepository</i>
     *<hr>
     *<p>Renvoie un User avec l'id spécifié</p>
     * @param id l'id du User cherché
     * @return le User
     */
    public User getUser(int id){
        String BASE_API_URL = props.getApiUrl();
        String getPersonUrl = BASE_API_URL + "/user/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(
                getPersonUrl,
                HttpMethod.GET,
                null,
                User.class
        );

        log.debug("Get User " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Méthode createUser
     *
     *<i>de UserRepository</i>
     *<hr>
     *<p>Renvoie le User une fois créé dans la BDD</p>
     * @param user le User à créer
     * @return le user créé
     */
    public User createUser(User user){
        String BASE_API_URL = props.getApiUrl();
        String createPersonUrl = BASE_API_URL + "/user";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(
                createPersonUrl,
                HttpMethod.POST,
                request,
                User.class
        );

        log.debug("Create User " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Méthode updateUser
     *
     *<i>de UserRepository</i>
     *<hr>
     *<p>Renvoie à la BDD un user à mettre à jour et renvoie le user</p>
     * @param user le user mis à jour
     * @return le user mis à jour si réussi
     */
    public User updateUser(User user){
        String BASE_API_URL = props.getApiUrl();
        String updatePersonUrl = BASE_API_URL + "/user/" + user.getIdUser();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        ResponseEntity<User> response = restTemplate.exchange(
                updatePersonUrl,
                HttpMethod.PUT,
                request,
                User.class
        );

        log.debug("Update User " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Méthode deleteUser
     *
     *<i>de UserRepository</i>
     *<hr>
     *<p>Supprime le User avec cet id, ne renvoie rien</p>
     * @param id l'id du User à supprimer
     */
    public void deleteUser(int id){
        String BASE_API_URL = props.getApiUrl();
        String getPersonUrl = BASE_API_URL + "/user/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> response = restTemplate.exchange(
                getPersonUrl,
                HttpMethod.DELETE,
                null,
                User.class
        );

        log.debug("Delete User " + response.getStatusCode());
    }
}
