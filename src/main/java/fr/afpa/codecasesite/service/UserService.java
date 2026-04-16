package fr.afpa.codecasesite.service;

import fr.afpa.codecasesite.model.User;
import fr.afpa.codecasesite.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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

    public Iterable<User> getUsers() throws HttpServerErrorException, HttpClientErrorException {
        return userRepository.getUsers();
    }

    public User getUser(int id) throws HttpServerErrorException, HttpClientErrorException{
        return userRepository.getUser(id);
    }

    public User getUserByMail(String mail) throws HttpServerErrorException, HttpClientErrorException{
        return userRepository.getUserByMail(mail);
    }

    public void deleteUser(int id) throws HttpServerErrorException, HttpClientErrorException{
        userRepository.deleteUser(id);
    }

    public User saveUser(User user) throws HttpServerErrorException, HttpClientErrorException{
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
