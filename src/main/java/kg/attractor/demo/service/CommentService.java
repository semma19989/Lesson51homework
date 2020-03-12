package kg.attractor.demo.service;



import kg.attractor.demo.repository.CommentRepo;
import kg.attractor.demo.repository.UserRepo;
import org.springframework.stereotype.Service;



@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final UserRepo userRepo;

    public CommentService(CommentRepo commentRepo,UserRepo userRepo) {
        this.commentRepo = commentRepo;
        this.userRepo=userRepo;
    }


}
