package kg.attractor.demo.repository;



import kg.attractor.demo.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepo extends CrudRepository<Song, String> {
    Song findAllById ( String id );
}