package map.project.demo.ui.cli;

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

    @ShellMethod(key = "add comment", value = "Add a comment")
    public String addComment(@ShellOption(value = { "author" }, help = "Author of the comment") final String author,
            @ShellOption(value = { "content" }, help = "Content of the comment") final String content,
            @ShellOption(value = { "postid" }, help = "Post id of the comment") final Long postId) {
        return postService.addCommentToPost(postId, author, content).toString();
    }
}
