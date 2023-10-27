package map.project.demo.service;

import java.util.List;

import jakarta.transaction.Transactional;
import map.project.demo.data.repository.PostRepository;
import map.project.demo.data.repository.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public Post addPostBy(String content, String author){
        Post post = new Post();
        post.setContent(content);
        post.setAuthor(userService.findByNameContaining("me"));
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
