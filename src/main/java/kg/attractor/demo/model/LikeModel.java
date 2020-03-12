package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "likes")
@Data
public class LikeModel{
@Id
        private int idLike;
        private User whoLikes;
        private Post whatLikes;
        private LocalDateTime timeLike;

}