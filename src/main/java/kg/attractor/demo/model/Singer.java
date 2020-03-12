package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="Singers")
@Data
public class Singer {
    @Id
    private String id;

    @Indexed(name="name", direction = IndexDirection.DESCENDING)
    private String singer;

    @DBRef
    private List<Album> albums = new ArrayList<>();
    public List<Album> getAlbums() {
        return albums;
    }
    public Singer(String id, String singer, List<Album> albums) {
        this.id = id;
        this.singer = singer;
        this.albums = albums;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }


}

