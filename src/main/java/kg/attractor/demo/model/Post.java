package kg.attractor.demo.model;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "posts")
@Data
public  class Post {

    public int id;
    private String imageLink;
    private LocalDateTime timePub;
    private String description;
    private List<Comment> comments = new ArrayList<>();
    public Post(int id, String imageLink, LocalDateTime timePub, String description, List<Comment> comments) {
        this.id = id;
        this.imageLink = imageLink;
        this.timePub = timePub;
        this.description = description;
        this.comments = comments;
    }

}