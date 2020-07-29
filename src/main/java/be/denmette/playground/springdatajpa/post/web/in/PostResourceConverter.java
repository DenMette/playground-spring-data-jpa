package be.denmette.playground.springdatajpa.post.web.in;

import be.denmette.playground.springdatajpa.post.Post;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostResourceConverter {

    public PostGetResource modelToResponseDTO(Post post) {
        PostGetResource postResource = new PostGetResource();
        postResource.setPostId(post.getId());
        postResource.setTitle(post.getTitle());
        postResource.setQuestion(post.getQuestion());

        if (post.getComments() != null)
            post.getComments().forEach(
                    c -> postResource.addAnswer(c.getAnswer())
            );

        return postResource;
    }

    public List<PostGetResource> modelToResponseListDTO(List<Post> posts) {
        return posts.stream().map(this::modelToResponseDTO).collect(Collectors.toList());
    }

    public Post requestDTOToModel(PostResource postResource) {
        Post post = new Post();
        post.setTitle(postResource.getTitle());
        post.setQuestion(postResource.getQuestion());
        post.setCreatedAt(new Date());
        return post;
    }
}
