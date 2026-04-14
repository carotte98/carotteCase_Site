package fr.afpa.codecasesite.service;

import fr.afpa.codecasesite.model.Tag;
import fr.afpa.codecasesite.repository.PostRepository;
import fr.afpa.codecasesite.repository.TagRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <h1>TagService</h1>
 * <hr>
 * <p> Service Tag
 * </p>
 *
 * @author loicrichard
 * @version 0.0.1
 * @since 2026/04/13
 */

@Data
@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private PostRepository postRepository;

    public Iterable<Tag>getTags() {return tagRepository.getTags();}
    public Tag getTag(Integer id) {return tagRepository.getTag(id);}
    public void deleteTag(Integer id) {tagRepository.deleteTag(id);}
    public Tag saveTag(Tag tag) {
        Tag saved;
        if (tag.getIdTag() != null) {
            saved = tagRepository.createTag(tag);
        } else {
            saved = tagRepository.updateTag(tag);
        }
        return saved;
    }
}
