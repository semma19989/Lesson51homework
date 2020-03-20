package kg.attractor.demo.service;

import kg.attractor.demo.dto.SubscriptionDto;
import kg.attractor.demo.exception.ResourceNotFoundException;
import kg.attractor.demo.model.Subscription;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.SubscriptionRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

i

@Service
public class SubscriptionService {
    private final SubscriptionRepo subscriptionRepo;
    private final UserRepo userRepo;

    public SubscriptionService(SubscriptionRepo subscriptionRepo, UserRepo userRepo) {
        this.subscriptionRepo = subscriptionRepo;
        this.userRepo = userRepo;
    }

    public SubscriptionDto addSubscription(SubscriptionDto subscriptionData, String followerName, String followingName) {
        User follower = userRepo.findByUsername(followerName)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + followerName));

        User following = userRepo.findByUsername(followingName)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + followingName));

        Subscription subscription = Subscription.builder()
                .id(subscriptionData.getId())
                .dateTime(subscriptionData.getDateTime())
                .follower(follower)
                .following(following)
                .build();

        subscriptionRepo.save(subscription);

        follower.addFollowings(following);
        following.addFollowers(follower);

        return SubscriptionDto.from(subscription);
    }
}
