package kg.attractor.demo.repository;


import kg.attractor.demo.model.PostImage;
import org.springframework.data.repository.CrudRepository;

public interface PostImageRepo extends CrudRepository<PostImage, String> {
}
