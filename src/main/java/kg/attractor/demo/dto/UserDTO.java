package kg.attractor.demo.dto;


import jdk.jshell.Snippet;
import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import lombok.*;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String password;
    private int numOfPosts;
    private int numOfFollowers;
    private int numOfFollowings;
    private List<User> followings;
    private List<User> followers;
    private List<Post> posts;

    public static UserDTO from(User user) {
        return builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .numOfPosts(user.getNumOfPosts())
                .numOfFollowers(user.getNumOfFollowers())
                .numOfFollowings(user.getNumOfFollowings())
                .posts(user.getPosts())
                .followers(user.getFollowers())
                .followings(user.getFollowings())
                .build();
    }

    private static Snippet builder() {
    }

    public Object getId() {
    }
}
