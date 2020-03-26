package kg.attractor.demo.model;


import kg.attractor.demo.utils.Generator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "posts")
@Data
public class Post {
    static Generator gen = new Generator();

    @Id
    private final String id;
    private final String image;
    private final String description;
    private final LocalDateTime dateTime;
    @Indexed
    private int numOfLikes;
    @DBRef
    private final User user;
    private final LocalDateTime localDateTime;
    private int numOfComments;

    public Post(String image, String description, User user) {
        this.id = UUID.randomUUID().toString();
        this.image = image;
        this.description = description;
        this.dateTime = LocalDateTime.now();
        this.user = user;
        this.localDateTime = LocalDateTime.now();
    }
}