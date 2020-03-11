package kg.attractor.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PublicationRepository extends MongoRepository<Publication, String> {
    //найти все публикации
    @Override
    List<Publication> findAll ();

    //найти публикации по названию
    List<Publication> findAllByTitle ( String query );

    //найти все публикации пользователя
    List<Publication> findAllByUser ( User user );

    //найти все публикации за определенное число
    List<Publication> findAllByPubDate ( LocalDate pubDate );

    //найти публикацию по ID
    @Override
    Optional<Publication> findById ( String id );
}
