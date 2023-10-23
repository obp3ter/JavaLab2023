package map.project.demo;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class MyCommands{

    @ShellMethod(key = "hello", value = "Say hello")
    public String hello(@ShellOption(value = { "name" }, help = "Your name") final String name) {
        return "Hello " + name + "!";
    }
}
