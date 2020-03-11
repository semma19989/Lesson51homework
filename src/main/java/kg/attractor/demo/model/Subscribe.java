package kg.attractor.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Subscribe {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final Random r = new Random();

    private static String generateId() {
        return LocalDateTime.now().format(dtf) + r.nextInt();
    }

    @Id
    private String id = generateId();
    @DBRef
    private User subscriber;
    @DBRef
    private User subscribeTarget;
    private LocalDate pubDate;

    public Subscribe(User subscriber, User subscribeTarget) {
        this.subscriber = subscriber;
        this.subscribeTarget = subscribeTarget;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public User getSubscribeTarget() {
        return subscribeTarget;
    }

    public void setSubscribeTarget(User subscribeTarget) {
        this.subscribeTarget = subscribeTarget;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }
}
