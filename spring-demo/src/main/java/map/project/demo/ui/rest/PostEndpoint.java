package map.project.demo.ui.rest;

import java.util.List;

import map.project.demo.data.dto.CommentDTO;
import map.project.demo.data.dto.PostDTO;
import map.project.demo.data.model.Post;
import map.project.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostEndpoint {

    @Autowired
    private PostService postService;

    @PostMapping
    public Post addPost(@RequestBody PostDTO request) {
        return postService.addPostBy(request.getAuthor(), request.getContent());
    }

    @GetMapping
    public List<Post> listPosts() {
        return postService.findAll();
    }

    @PostMapping("/{postId}/comment")
    public Post addComment(@PathVariable Long postId, @RequestBody CommentDTO request) {
        return postService.addCommentToPost(postId, request.getAuthor(), request.getContent());
    }
}
