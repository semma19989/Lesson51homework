package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "comments")
@Data
public class Comment {
    @Id
    private String idComment;
    private String commentText;
    private LocalDateTime timeCom;
    private User author;
    private List<Comment> childComments=new ArrayList<>();

    public Comment ( String first_comment, User u1, Publication p2 ) {
    }
}