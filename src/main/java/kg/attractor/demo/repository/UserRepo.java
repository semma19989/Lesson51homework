package kg.attractor.demo.repository;


import kg.attractor.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepo extends PagingAndSortingRepository<User, String> {

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Page<User> findAllByUsernameNotContains(Pageable pageable, String username);
    void deleteByUsername(String username);
}
