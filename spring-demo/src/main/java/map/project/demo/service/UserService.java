package map.project.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import map.project.demo.data.repository.UserRepository;
import map.project.demo.data.repository.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
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
}