package kg.attractor.demo.dto;


import kg.attractor.demo.model.Post;
import kg.attractor.demo.repository.LikeRepository;
import lombok.*;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PostDTO {
    private String id;
    private String image;
    private String description;
    private int numOfLikes;
    private List<LikeRepository.Like> likes;

    public static PostDTO from(Post post) {
        return builder()
                .id(post.getId())
                .image(post.getImage())
                .description(post.getDescription())
                .numOfLikes(post.getNumOfLikes())
                .likes(post.getLikes())
                .build();
    }
}
