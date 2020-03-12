package kg.attractor.demo.controller;



import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.PostRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;
    private Object User;

    @GetMapping("/user/all")
    public String root(Model model) {
        model.addAttribute("user", userRepo.findAll());
        return "user";
    }


    @PostMapping("/user")
    public User createUser( @RequestBody User user) {

        // merge
        User userN = userRepo.findById(user.id).orElse((kg.attractor.demo.model.User) User);
        for (Post t : user.posts) {
            if (userN.posts.stream().filter(x -> {
                return Objects.equals(x.id, t.id);
            }).count() == 0)
                userN.posts.add(t);
        }

        // save
        List<Post> tasks = userN.posts;
        for (Post t : tasks)
            postRepo.save(t);

        userRepo.save(userN);

        return userN;
    }

    @DeleteMapping("/user/{id}")
    public Optional<User> deleteUser(@PathVariable String id) {
        Optional<User> user = userRepo.findById(id);
        userRepo.deleteById(id);

        return user;
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable String id) {
        Optional<User> user = userRepo.findById(id);

        return user;
    }

}
