package kg.attractor.demo.service;


import kg.attractor.demo.dto.PostDTO;
import kg.attractor.demo.exception.ResourceNotFoundException;
import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.PostRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public PostService(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public PostDTO addPost(PostDTO postData, String username) {
        Post post = Post.builder()
                .id(postData.getId())
                .image(postData.getImage())
                .description(postData.getDescription())
                .numOfLikes(postData.getNumOfLikes())
                .likes(postData.getLikes())
                .build();
        User userData = userRepo.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + username));
        System.out.println(username + " before " + userData.getPosts().size());
        userData.addPost(post);

        System.out.println(username + " after " + userData.getPosts().size());
        postRepo.save(post);
        return PostDTO.from(post);
    }

}
