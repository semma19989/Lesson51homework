package kg.attractor.demo.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    //найти всех пользователей
    @Override
    List<User> findAll ();

    //найти пользователя по ID
    @Override
    Optional<User> findById ( String s );

    //проверить существует ли уже пользователь с таким именем
    Boolean findByUserName ( String userName );

    //проверить есть ли у пользователя email
    Boolean findByEmail ( String email );
}
