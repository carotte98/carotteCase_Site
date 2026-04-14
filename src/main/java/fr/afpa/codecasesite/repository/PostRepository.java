package fr.afpa.codecasesite.repository;

import fr.afpa.codecasesite.config.CustomProperties;
import fr.afpa.codecasesite.model.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * PostRepository
 * <i>de fr.afpa.codecasesite.repository</i>
 * <hr>
 * <p>Repository qui fait le lien entre l'api et la webapp de Post</p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/13
 */

@Slf4j
@Component
public class PostRepository {
  /**
   * Les propriétés customs
   */
  @Autowired
  private CustomProperties props;


  /**
   * Méthode getPost
   *
   *<i>de PostRepository</i>
   *<hr>
   *<p>Renvoie tous les Posts en BDD</p>
   * @return un Iterable de Post
   */
  public Iterable<Post> getPosts(){
    String BASE_API_URL = props.getApiUrl();
    String getPostsUrl = BASE_API_URL + "/posts";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Iterable<Post>> response = restTemplate.exchange(
        getPostsUrl,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<>() {}
    );

    log.debug("Get Posts " + response.getStatusCode());

    return response.getBody();
  }

  /**
   * Méthode getPost
   *
   *<i>de PostRepository</i>
   *<hr>
   *<p>Renvoie un Post avec l'id spécifié</p>
   * @param id l'id du Post cherché
   * @return le Post
   */
  public Post getPost(int id){
    String BASE_API_URL = props.getApiUrl();
    String getPostUrl = BASE_API_URL + "/post/" + id;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Post> response = restTemplate.exchange(
        getPostUrl,
        HttpMethod.GET,
        null,
        Post.class
    );

    log.debug("Get Post " + response.getStatusCode());

    return response.getBody();
  }

  /**
   * Méthode createPost
   *
   *<i>de PostRepository</i>
   *<hr>
   *<p>Renvoie le Post une fois créé dans la BDD</p>
   * @param post le Post à créer
   * @return le Post créé
   */
  public Post createPost(Post post){
    String BASE_API_URL = props.getApiUrl();
    String createPostUrl = BASE_API_URL + "/post";

    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<Post> request = new HttpEntity<>(post);
    ResponseEntity<Post> response = restTemplate.exchange(
        createPostUrl,
        HttpMethod.POST,
        request,
        Post.class
    );

    log.debug("Create Post " + response.getStatusCode());

    return response.getBody();
  }

  /**
   * Méthode updatePost
   *
   *<i>de PostRepository</i>
   *<hr>
   *<p>Renvoie à la BDD un post à mettre à jour et renvoie le post</p>
   * @param post le post mis à jour
   * @return le post mis à jour si réussi
   */
  public Post updatePost(Post post){
    String BASE_API_URL = props.getApiUrl();
    String updatePostUrl = BASE_API_URL + "/post/" + post.getIdPost();

    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<Post> request = new HttpEntity<>(post);
    ResponseEntity<Post> response = restTemplate.exchange(
        updatePostUrl,
        HttpMethod.PUT,
        request,
        Post.class
    );

    log.debug("Update Post " + response.getStatusCode());

    return response.getBody();
  }

  /**
   * Méthode deletePost
   *
   *<i>de PostRepository</i>
   *<hr>
   *<p>Supprime le Post avec cet id, ne renvoie rien</p>
   * @param id l'id du Post à supprimer
   */
  public void deletePost(int id){
    String BASE_API_URL = props.getApiUrl();
    String getPostUrl = BASE_API_URL + "/post/" + id;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Post> response = restTemplate.exchange(
        getPostUrl,
        HttpMethod.DELETE,
        null,
        Post.class
    );

    log.debug("Delete Post " + response.getStatusCode());
  }
}
