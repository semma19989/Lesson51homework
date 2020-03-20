package kg.attractor.demo.dto;


import kg.attractor.demo.model.Subscription;
import kg.attractor.demo.model.User;
import lombok.*;

import java.time.LocalDateTime;

import static kg.attractor.demo.model.User.builder;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDto {

    private String id;
    private User following;
    private User follower;
    private LocalDateTime dateTime;

    public static SubscriptionDto from(Subscription subscription) {
        return builder()
                .id(subscription.getId())
                .follower(subscription.getFollower())
                .following(subscription.getFollowing())
                .dateTime(subscription.getDateTime())
                .build();
    }

    public Object getId() {
    }

    public Object getDateTime() {
    }
}
