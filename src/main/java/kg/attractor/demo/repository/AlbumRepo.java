package kg.attractor.demo.repository;



import kg.attractor.demo.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepo extends CrudRepository<Album, String> {

}
