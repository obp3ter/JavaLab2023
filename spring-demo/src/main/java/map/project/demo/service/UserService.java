package map.project.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import map.project.demo.data.model.User;
import map.project.demo.data.model.UserProfile;
import map.project.demo.data.repository.UserRepository;
import map.project.demo.util.Validators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(String name) {
        User user = new User();

        if (Validators.validateName(name)) {
            user.setName(name);
        } else {
            log.error("Invalid name");
            throw new IllegalArgumentException("Invalid name");
        }

        if (userRepository.findByName(name).stream().findFirst().isPresent()) {
            log.error("User already exists");
            throw new IllegalArgumentException("User already exists");
        }

        return userRepository.save(user);
    }

    public User addBio(String name, String bio) {
        User user = userRepository.findByName(name).stream().findFirst().orElse(null);
        if (user != null) {
            user.setProfile(new UserProfile(bio));
            return userRepository.save(user);
        } else {
            log.error("User not found");
            throw new IllegalArgumentException("User not found");
        }
    }

    public User findByName(String name) {
        return userRepository.findByName(name).stream().findFirst().orElse(null);
    }

    public User findByNameContaining(String name) {
        return userRepository.findByNameContaining(name).stream().findFirst().orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addFriend(String name, String friend) {
        User user = userRepository.findByName(name).stream().findFirst().orElse(null);
        User friendUser = userRepository.findByName(friend).stream().findFirst().orElse(null);
        if (user != null && friendUser != null) {
            user.getFriends().add(friendUser);
            return userRepository.save(user);
        } else {
            log.error("User not found");
            throw new IllegalArgumentException("User not found");
        }
    }
}
