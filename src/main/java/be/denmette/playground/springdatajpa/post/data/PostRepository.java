package be.denmette.playground.springdatajpa.post.data;

import be.denmette.playground.springdatajpa.post.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
}
