package kg.attractor.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ikeRepository extends MongoRepository<Like, String> {
    //посчитать все лайки публикации
    int findAllByPublication ( Publication publication );
}
