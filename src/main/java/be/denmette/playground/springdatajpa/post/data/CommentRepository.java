package be.denmette.playground.springdatajpa.post.data;

import be.denmette.playground.springdatajpa.post.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
