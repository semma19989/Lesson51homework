package kg.attractor.demo.service;


import kg.attractor.demo.dto.PostDTO;
import kg.attractor.demo.exception.ResourceNotFoundException;
import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.CommentRepo;
import kg.attractor.demo.repository.LikeRepo;
import kg.attractor.demo.repository.PostRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;
    private final LikeRepo likeRepo;
    private final CommentRepo commentRepo;

    public PostService(PostRepo postRepo, UserRepo userRepo, LikeRepo likeRepo, CommentRepo commentRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
        this.likeRepo = likeRepo;
        this.commentRepo = commentRepo;
    }

    public Page<PostDTO> findPosts(Pageable pageable) {
        Page<Post> posts = postRepo.findAll(pageable);
        updateNumbers(posts);
        return posts.map(PostDTO::from);
    }

    public Page<PostDTO> findPostsByEmail(Pageable pageable, String email) {
        Page<Post> posts = postRepo.findAllByUserEmail(pageable, email);
        updateNumbers(posts);
        return posts.map(PostDTO::from);
    }

    public PostDTO findUserById(String postId) {
        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find post with the id: " + postId));
        updateNumbers(post);
        return PostDTO.from(post);
    }

    public PostDTO addPost(PostDTO postData, String username) {

        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + username));

        Post post = Post.builder()
                .id(postData.getId())
                .user(user)
                .image(postData.getImage())
                .description(postData.getDescription())
                .numOfLikes(postData.getNumOfLikes())
                .numOfComments(postData.getNumOfComments())
                .localDateTime(LocalDateTime.now())
                .build();

        postRepo.save(post);
        return PostDTO.from(post);
    }

    public boolean deletePost(String postId) {
        postRepo.deleteById(postId);
        return true;
    }

    private void updateNumbers(Post post) {
        post.setNumOfLikes(likeRepo.countByPostId(post.getId()));
        post.setNumOfComments(commentRepo.countByPostId(post.getId()));
    }

    private void updateNumbers(Iterable<Post> posts) {
        posts.forEach(post -> {
            post.setNumOfLikes(likeRepo.countByPostId(post.getId()));
            post.setNumOfComments(commentRepo.countByPostId(post.getId()));
        });
    }
}
