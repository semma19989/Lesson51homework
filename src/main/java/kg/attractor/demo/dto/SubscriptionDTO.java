package kg.attractor.demo.dto;

import kz.attractorschool.microgram.model.Subscription;
import kz.attractorschool.microgram.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDTO {

    private String id;
    private User following;
    private User follower;
    private LocalDateTime dateTime;

    public static SubscriptionDTO from(Subscription subscription) {
        return builder()
                .id(subscription.getId())
                .follower(subscription.getFollower())
                .following(subscription.getFollowing())
                .dateTime(subscription.getDateTime())
                .build();
    }
}
