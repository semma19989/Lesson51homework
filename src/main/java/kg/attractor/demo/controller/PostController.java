package kg.attractor.demo.controller;


import kg.attractor.demo.dto.PostDTO;
import kg.attractor.demo.service.PostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{username}/add")
    public PostDTO addPost(@RequestBody PostDTO postData, @PathVariable String username) {
        return postService.addPost(postData, username);
    }
}
