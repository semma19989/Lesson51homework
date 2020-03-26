package kg.attractor.demo.service;


import kg.attractor.demo.dto.LikeDTO;
import kg.attractor.demo.exception.ResourceNotFoundException;
import kg.attractor.demo.model.Like;
import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.LikeRepo;
import kg.attractor.demo.repository.PostRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LikeService {
    private final LikeRepo likeRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public LikeService(LikeRepo likeRepo, PostRepo postRepo, UserRepo userRepo) {
        this.likeRepo = likeRepo;
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public Page<LikeDTO> findLikesByPostId(Pageable pageable, String postId) {
        Page<Like> likes = likeRepo.findAllByPostId(pageable, postId);
        return likes.map(LikeDTO::from);
    }

    public LikeDTO addLike(String postId, String likerUsername) {

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the id: " + postId));

        User user = userRepo.findByUsername(likerUsername)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + likerUsername));

        Like like = Like.builder()
                .id(UUID.randomUUID().toString())
                .liker(user)
                .post(post)
                .dateTime(LocalDateTime.now())
                .build();

        likeRepo.save(like);

        return LikeDTO.from(like);
    }

    public boolean deleteLike(String likeId) {
        likeRepo.deleteById(likeId);
        return true;
    }
}
