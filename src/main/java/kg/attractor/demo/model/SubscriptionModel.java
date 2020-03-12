package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Document(collection = "subscribers")
@Data
public class SubscriptionModel{
    @Id
    private User userWhoSubs;
    private User userWhom;
    private LocalDateTime timeSub;


}