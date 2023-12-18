package map.project.demo.ui.rest;

import java.util.List;

import map.project.demo.data.dto.BioDTO;
import map.project.demo.data.dto.UserDTO;
import map.project.demo.data.model.User;
import map.project.demo.service.UserService;
import map.project.demo.util.mvc.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

    @Autowired
    private UserService userService;

    /**
     * Lists all users
     * @return the list of users
     */
    @GetMapping()
    public List<User> listUsers() {
        return userService.findAll();
    }

    /**
     * Creates a new user
     * @param request the request body
     * @return the created user
     */
    @PostMapping()
    public User addUser(@RequestBody UserDTO request) {
        return userService.save(request.getName());
    }

    /**
     * Finds a user by name
     * @param name the name of the user
     * @return the user
     */
    @GetMapping("/{name}")
    public User findUser(@PathVariable String name) {
        return userService.findByName(name);
    }

    /**
     * Finds a user by name
     * @param name the name of the user
     * @return the user
     */
    @GetMapping("/like/{name}")
    public User findUserLike(@PathVariable String name) {
        return userService.findByNameContaining(name);
    }

    /**
     * Adds a bio to a user
     * @param request the request body
     * @return the updated user
     */
    @PostMapping("/bio")
    public User addBio(@RequestBody BioDTO request) {
        return userService.addBio(request.getName(), request.getBio());
    }

    /**
     * Adds a follow to a user
     * @param name the name of the user
     * @param friend the name of the friend
     * @return the updated user
     */
    @PostMapping("/follow")
    public User addFollow(@JsonParam String name, @JsonParam String friend) {
        return userService.addFollowing(name, friend);
    }
}
