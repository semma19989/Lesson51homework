package kg.attractor.demo.model;
import kg.attractor.demo.repository.LikeRepository;
import kg.attractor.demo.util.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static kg.attractor.demo.model.LikeModel.getLikes;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "posts")
@Data
public class Post {
    private static final List<Post> posts = makePosts();
    static Generator gen = new Generator();
    @Id
    private final String id;
    private final String image;
    private final String description;
    @DBRef
    private final List<LikeRepository.Like> likes = new LinkedList<>();
    private LocalDateTime dateTime = LocalDateTime.now();
    @Indexed
    private int numOfLikes;

    public Post(String image, String description, LocalDateTime dateTime) {
        this.id = UUID.randomUUID().toString();
        this.image = image;
        this.description = description;
        this.dateTime = dateTime;
        this.numOfLikes = getLikes().size();
    }

    private static List<Post> makePosts() {
        List<Post> posts = new LinkedList<>();
        LocalDateTime dateTime = LocalDateTime.now();
        posts.add(new Post("", Generator.makeDescription(), dateTime));
        posts.add(new Post("", Generator.makeDescription(), dateTime.minusDays(4)));
        posts.add(new Post("", Generator.makeDescription(), dateTime.minusMinutes(5)));
        return posts;
    }

    public static List<Post> getPosts() {
        return posts;
    }

    public void addLike(LikeModel like) {
        getLikes().add(like);
        setLikes(getLikes());
        updateNumOfLikes();
    }

    private void setLikes(List<LikeRepository.Like> likes) {
    }

    public void updateNumOfLikes() {
        this.numOfLikes = getLikes().size();
    }

    public Object getDescription() {
    }
}