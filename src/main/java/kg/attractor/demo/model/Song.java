package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@Data
public class Song {
    @Id
    private String id;
    @Indexed (name="composition")
    private String composition;
    private Singer singer;
    public Song(String id, String composition) {
        this.id = id;
        this.composition = composition;
    }


    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }


}
