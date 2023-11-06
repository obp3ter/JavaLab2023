package map.project.demo.cli;

import map.project.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class PostCLICommands {

    @Autowired
    private PostService postService;

    @ShellMethod(key = "add post", value = "Add a post")
    public String addPost(@ShellOption(value = { "author" }, help = "Author of the post") final String author,
            @ShellOption(value = { "content" }, help = "Content of the post") final String content) {
        return postService.addPostBy(author, content).toString();
    }

    @ShellMethod(key = "list post", value = "List all posts")
    public String listPosts() {
        return postService.findAll().toString();
    }
}
