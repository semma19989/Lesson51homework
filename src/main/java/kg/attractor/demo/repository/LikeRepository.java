package kg.attractor.demo.repository;


import org.springframework.data.repository.CrudRepository;

public interface LikeRepository<LikeModel> extends CrudRepository<LikeModel, String> {

    void save(Like like);

    class Like {
    }
}
