package kg.attractor.demo.repository;



import kg.attractor.demo.model.SubscriptionModel;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<SubscriptionModel, String> {

}
