package kg.attractor.demo.dto;

import kz.attractorschool.microgram.model.Post;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PostDTO {
    private String id;
    private String image;
    private String description;
    private int numOfLikes;
    private int numOfComments;
    private LocalDateTime dateTime;

    public static PostDTO from(Post post) {
        return builder()
                .id(post.getId())
                .image(post.getImage())
                .description(post.getDescription())
                .numOfLikes(post.getNumOfLikes())
                .numOfComments(post.getNumOfComments())
                .dateTime(post.getDateTime())
                .build();
    }
}
