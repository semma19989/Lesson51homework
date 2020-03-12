package kg.attractor.demo.repository;



import kg.attractor.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, String> {

}
