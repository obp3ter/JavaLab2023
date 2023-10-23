package map.project.demo.cli;

import map.project.demo.data.repository.model.User;
import map.project.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserCLICommands {

    @Autowired
    private UserService userService;

    @ShellMethod(key = "list", value = "List all users")
    public String listUsers() {
        return userService.findAll().toString();
    }

    @ShellMethod(key = "add", value = "Add a user")
    public String addUser(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        User user = new User();
        user.setName(name);
        return userService.save(user).toString();
    }

    @ShellMethod(key = "find", value = "Find a user")
    public String findUser(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        return userService.findByName(name).toString();
    }

    @ShellMethod(key = "findlike", value = "Find a user")
    public String findUserLike(@ShellOption(value = { "name" }, help = "Name of the user") final String name) {
        return userService.findByNameContaining(name).toString();
    }
}
