package fr.afpa.codecasesite.service;

import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 * <i>de fr.afpa.codecasesite.service</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 10/04/2026
 */
@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers(){
        return userRepository.getUsers();
    }

    public User getUser(int id){
        return userRepository.getUser(id);
    }

    public void deleteUser(int id){
        userRepository.deleteUser(id);
    }

    public User saveUser(User user){
        User saved;

        if (user.getIdUser() == null){
            System.out.println("create");
            saved = userRepository.createUser(user);
        }else{
            System.out.println("update");
            saved = userRepository.updateUser(user);
        }

        return saved;
    }
}
