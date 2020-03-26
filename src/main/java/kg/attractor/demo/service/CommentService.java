package kg.attractor.demo.service;


import kg.attractor.demo.dto.CommentDTO;
import kg.attractor.demo.exception.ResourceNotFoundException;
import kg.attractor.demo.model.Comment;
import kg.attractor.demo.model.Post;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.CommentRepo;
import kg.attractor.demo.repository.PostRepo;
import kg.attractor.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepo commentRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    public Slice<CommentDTO> findCommentByPostId(Pageable pageable, String postId) {

        Slice<Comment> comments = commentRepo.findAllByPostId(pageable, postId);
        return comments.map(CommentDTO::from);
    }

    public CommentDTO addComment(CommentDTO commentData, String postId, String commenterUsername) {

        Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the id: " + postId));

        User user = userRepo.findByUsername(commenterUsername)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find user with the name: " + commenterUsername));

        Comment comment = Comment.builder()
                .id(commentData.getId())
                .commenter(user)
                .post(post)
                .dateTime(LocalDateTime.now())
                .text(commentData.getText())
                .path(commentData.getPath())
                .build();

        commentRepo.save(comment);

        return CommentDTO.from(comment);
    }

    public boolean deleteComment(String commentId) {
        commentRepo.deleteById(commentId);
        return true;
    }
}
