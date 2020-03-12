package kg.attractor.demo.util;




import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class PreloaderDatabase {

    @Bean
    CommandLineRunner initDatabase( UserRepo repository) {

        repository.deleteAll();

        return (args) -> Stream.of(users())
                .peek(System.out::println)
                .forEach(repository::save);
    }

    private User[] users() {
        return new User[]{
                new User("1", "semma", "semm1998ac@gmail.com",null),
                new User("2", "syimuk", "semm1998@bk.ru",null)};
    }
}
