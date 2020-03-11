package kg.attractor.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SubscribeRepository extends MongoRepository<Subscribe, String> {
    //найти все подписки пользователя
    List<Subscribe> findAllBySubscriber ( User subscriber );

    //найти подписку по ID
    @Override
    Optional<Subscribe> findById ( String id );
}
