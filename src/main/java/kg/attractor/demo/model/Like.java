package kg.attractor.demo.model;

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
@Document(collection = "likes")
@Data
public class Like {

    @Id
    private final String id;
    @Indexed
    private final User liker;
    @DBRef
    private final Post post;
    private final LocalDateTime dateTime;

    public Like(User liker, Post post) {
        this.id = UUID.randomUUID().toString();
        this.liker = liker;
        this.post = post;
        this.dateTime = LocalDateTime.now();
    }
}
