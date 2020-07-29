package be.denmette.playground.springdatajpa.post.web.in;

import be.denmette.playground.springdatajpa.post.Post;
import be.denmette.playground.springdatajpa.post.PostService;
import be.denmette.playground.springdatajpa.post.data.PostRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostService service;
    private final PostResourceConverter resourceConverter;

    public PostController(PostService service, PostResourceConverter resourceConverter) {
        this.service = service;
        this.resourceConverter = resourceConverter;
    }

    @GetMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostGetResource>> getPosts() {
        List<Post> posts = service.getAllPosts();
        return ResponseEntity.ok(resourceConverter.modelToResponseListDTO(posts));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostGetResource> getPost(@PathVariable int id) {
        PostGetResource postGetResource = resourceConverter.modelToResponseDTO(service.getPost(id));
        return ResponseEntity.ok(postGetResource);
    }

    @PostMapping
    public ResponseEntity<PostGetResource> createPost(@RequestBody PostResource postResource) {
        Post post = resourceConverter.requestDTOToModel(postResource);
        PostGetResource postGetResource = resourceConverter.modelToResponseDTO(service.createPost(post));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).body(postGetResource);
    }
}
