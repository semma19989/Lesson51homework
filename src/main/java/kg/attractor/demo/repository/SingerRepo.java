package kg.attractor.demo.repository;



import kg.attractor.demo.model.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepo extends CrudRepository<Singer, String> {
    Singer findAllById ( String id );


}
