package kg.attractor.demo.repository;


import kg.attractor.demo.model.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubscriptionRepo extends PagingAndSortingRepository<Subscription, String> {
    int countByFollowerEmail(String email);

    int countByFollowingEmail(String email);

    Page<Subscription> findAllByFollowerEmail(Pageable pageable, String email);
}
