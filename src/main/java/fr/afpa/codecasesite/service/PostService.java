package fr.afpa.codecasesite.service;

import fr.afpa.codecasesite.model.Post;
import fr.afpa.codecasesite.repository.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PostService
 * <i>de fr.afpa.codecasesite.service</i>
 * <hr>
 * <p></p>
 *
 * @author Calderoli Alexandre
 * @version 0.0.1
 * @since 2026/04/13
 */

@Data
@Service
public class PostService {

  @Autowired
  private PostRepository postRepository;

  public Iterable<Post> getPosts(){
    return postRepository.getPosts();
  }

  public Post getPost(int id){
    return postRepository.getPost(id);
  }

  public void deletePost(int id){
    postRepository.deletePost(id);
  }

  public Post savePost(Post post){
    Post saved;

    if (post.getIdPost() == null){
      saved = postRepository.createPost(post);
    }else{
      saved = postRepository.updatePost(post);
    }

    return saved;
  }
}
