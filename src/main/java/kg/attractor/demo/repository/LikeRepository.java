package kg.attractor.demo.repository;




import kg.attractor.demo.model.Like;
import kg.attractor.demo.model.LikeModel;
import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<LikeModel, String> {

    void save ( Like like );
}
