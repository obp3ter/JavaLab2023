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

    @GetMapping()
    public List<User> listUsers() {
        return userService.findAll();
    }

    @PostMapping()
    public User addUser(@RequestBody UserDTO request) {
        return userService.save(request.getName());
    }

    @GetMapping("/{name}")
    public User findUser(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/like/{name}")
    public User findUserLike(@PathVariable String name) {
        return userService.findByNameContaining(name);
    }

    @PostMapping("/bio")
    public User addBio(@RequestBody BioDTO request) {
        return userService.addBio(request.getName(), request.getBio());
    }

    @PostMapping("/follow")
    public User addFollow(@JsonParam String name, @JsonParam String friend) {
        return userService.addFollowing(name, friend);
    }
}
