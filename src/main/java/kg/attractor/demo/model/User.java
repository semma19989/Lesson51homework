package kg.attractor.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "users")
@Data
public class User {
    public static final User EMPTY = new User("No one", "none@gmail.com", "nothing");
    private static final List<User> users = makeUsers();
    @Id
    private final String id;
    @Indexed
    private final String username;
    @Indexed
    private final String email;
    private final String password;
    @DBRef
    private final List<User> followings = new ArrayList<>();
    @DBRef
    private final List<User> followers = new ArrayList<>();
    private int numOfPosts = 0;
    private int numOfFollowers;
    private int numOfFollowings;
    @DBRef
    private List<Post> posts = new ArrayList<>();

    public User(String username, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.password = password;
        this.numOfPosts = getPosts().size();
        this.numOfFollowers = getFollowers().size();
        this.numOfFollowings = getFollowings().size();
    }

    private static List<User> makeUsers() {
        List<User> users = new LinkedList<>();
        users.add(new User("w", "w@gmail.com", "w"));
        users.add(new User("d", "d@gmail.com", "d"));
        users.add(new User("f", "f@gmail.com", "f"));
        users.add(new User("bg", "bd@gmail.com", "bg"));
        users.add(new User("sn", "sn@gmail.com", "sn"));
        return users;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void subscribe(int follower, int following) {
        User.getUsers().get(following).addFollowers(User.getUsers().get(follower));
        User.getUsers().get(follower).addFollowings(User.getUsers().get(following));
    }

    private Collection<Object> getFollowers() {
    }

    public void addPost(Post newPost) {
        getPosts().add(newPost);
        setPosts(getPosts());
        updateNumOfPosts();
    }

    public void addFollowers(User follower) {
        getFollowers().add(follower);
        setFollowers(getFollowers());
        updateNumOfFollowers();
    }

    public void addFollowings(User following) {
        getFollowings().add(following);
        setFollowings(getFollowings());
        updateNumOfFollowings();
    }

    public void updateNumOfPosts() {
        this.numOfPosts = getPosts().size();
    }

    public void updateNumOfFollowers() {
        this.numOfFollowers = getFollowers().size();
    }

    public void updateNumOfFollowings() {
        this.numOfFollowings = getFollowings().size();
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Object getUsername() {
    }
}
