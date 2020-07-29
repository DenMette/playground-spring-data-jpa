package be.denmette.playground.springdatajpa.post;

import be.denmette.playground.springdatajpa.post.data.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return (ArrayList<Post>) postRepository.findAll();
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElseThrow(() -> new UnsupportedOperationException("No data found"));
    }

    @Transactional
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
