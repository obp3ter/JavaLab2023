package map.project.demo.ui.cli;

import map.project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserCLICommands {

    @Autowired
    private UserService userService;

    @ShellMethod(key = "list user", value = "List all users")
    public String listUsers() {
        return userService.findAll().toString();
    }

    @ShellMethod(key = "add user", value = "Add a user")
    public String addUser(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        return userService.save(name).toString();
    }

    @ShellMethod(key = "find user", value = "Find a user")
    public String findUser(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        return userService.findByName(name).toString();
    }

    @ShellMethod(key = "findlike", value = "Find a user")
    public String findUserLike(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        return userService.findByNameContaining(name).toString();
    }

    @ShellMethod(key = "add bio", value = "Add a bio")
    public String addBio(@ShellOption(value = { "name" }, help = "Name of the user") final String name,
            @ShellOption(value = { "bio" }, help = "Bio of the user") final String bio) {
        return userService.addBio(name, bio).toString();
    }

    @ShellMethod(key = "add follow", value = "Follow a user")
    public String addFriend(@ShellOption(value = { "name" }, help = "Name of the user") final String name,
            @ShellOption(value = { "friend" }, help = "Name of the friend") final String friend) {
        return userService.addFollowing(name, friend).toString();
    }
}
