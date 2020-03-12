package kg.attractor.demo.repository;



import kg.attractor.demo.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, String> {

}
