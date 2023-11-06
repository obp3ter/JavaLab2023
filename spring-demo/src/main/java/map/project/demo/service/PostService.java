package map.project.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;
import map.project.demo.data.model.Post;
import map.project.demo.data.model.User;
import map.project.demo.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public Post addPostBy(String author, String content) {
        Post post = new Post();
        post.setContent(content);
        User user = userService.findByName(author);
        if (user != null) {
            post.setAuthor(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
