package kg.attractor.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CommentRepository extends MongoRepository<Comment, String> {
    //найти все комментарии пользователя
    List<Comment> findAllByUser ( User user );

    //найти все комментарии к публикации
    List<Comment> findAllByPublication ( Publication publication );

    //найти все комментарии за определенную дату
    List<Comment> findAllByPubDate ( LocalDate pubDate );

    //найти комментарий по ID
    @Override
    Optional<Comment> findById ( String id );
}
