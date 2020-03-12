package kg.attractor.demo.repository;

import kg.attractor.demo.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, String> {

}
