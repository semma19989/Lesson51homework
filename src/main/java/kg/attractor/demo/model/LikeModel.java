package kg.attractor.demo.model;

import kg.attractor.demo.repository.LikeRepository;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Document(collection = "likes")
@Data
public class LikeModel extends LikeRepository.Like {
        private static final List<LikeRepository.Like> likes = makeLikes();
        @Id
        private String id;
        @Indexed
        private String user;
        @Indexed
        private String post;
        private LocalDateTime dateTime;

        private static List<LikeRepository.Like> makeLikes() {
                LocalDateTime dateTime = LocalDateTime.now();
                List<LikeRepository.Like> likes = new LinkedList<>();
                likes.add(new LikeRepository.Like(User.getUsers().get(2).getUsername(), Post.getPosts().get(1).getDescription(), dateTime.minusDays(4)));
                likes.add(new LikeRepository.Like(User.getUsers().get(3).getUsername(), Post.getPosts().get(2).getDescription(), dateTime.minusDays(2)));
                likes.add(new LikeRepository.Like(User.getUsers().get(3).getUsername(), Post.getPosts().get(1).getDescription(), dateTime.minusDays(3)));
                return likes;
        }

        public static List<LikeRepository.Like> getLikes() {
                return likes;
        }

        public void Like(String user, String post, LocalDateTime dateTime) {
                this.id = UUID.randomUUID().toString();
                this.user = user;
                this.post = post;
                this.dateTime = dateTime;
        }
}
