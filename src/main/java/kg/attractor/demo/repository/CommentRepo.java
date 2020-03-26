package kg.attractor.demo.repository;

import kg.attractor.demo.model.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepo extends PagingAndSortingRepository<Comment, String> {
    int countByPostId(String postId);

    Slice<Comment> findAllByPostId(Pageable pageable, String postId);
}
