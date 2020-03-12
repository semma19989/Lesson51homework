package kg.attractor.demo.util;
import kg.attractor.demo.model.*;
import kg.attractor.demo.repository.LikeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {
    User u1, u2;
    Publication p1, p2, p3;
/*



 */
    @Bean
    CommandLineRunner initUsersData( UserRepository userRepository) {
        userRepository.deleteAll();

        return (args) -> Stream.of(users())
                .forEach(userRepository::save);
    }

    private User[] users() {
        u1 = new User("aaa", "semm@example.com", "123");
        u2 = new User("Malica", "Malica@example.com", "555");
        return new User[]{u1, u2};
    }

    @Bean
    CommandLineRunner initPublicationsData( PublicationRepository publicationRepository) {
        publicationRepository.deleteAll();

        return (args) -> Stream.of(publications())
                .forEach(publicationRepository::save);
    }

    private Publication[] publications() {
        p1 = new Publication("Hello!", "pub.jpg", "Smart description", u1);
        p2 = new Publication("Test", "test.jpg", "Test publication", u2);
        p3 = new Publication("Awesome", "awesome.jpg", "Awesome publication", u1);
        return new Publication[]{p1, p2, p3};
    }

    CommandLineRunner initCommentData( CommentRepository commentRepository) {
        commentRepository.deleteAll();

        return (args) -> Stream.of(comments())
                .forEach(commentRepository::save);
    }

    private Comment[] comments() {
        return new Comment[]{
                new Comment("First Comment", u1, p2),
                new Comment("Second Comment", u2, p1)
        };
    }

    @Bean
    CommandLineRunner initLikeData( LikeRepository likeRepository) {
        likeRepository.deleteAll();

        return (args) -> Stream.of(likes())
                .forEach(likeRepository::save);
    }

    private Like[] likes() {
        return new Like[]{
                new Like(p1),
                new Like(p2),
                new Like(p3),
                new Like(p3)
        };
    }

    @Bean
    CommandLineRunner initSubscribeData(SubscribeRepository subscribeRepository) {
        subscribeRepository.deleteAll();

        return (args) -> Stream.of(subscribes())
                .forEach(subscribeRepository::save);
    }

    private Subscribe[] subscribes() {
        return new Subscribe[]{
                new Subscribe(u1, u2)
        };
    }
}
