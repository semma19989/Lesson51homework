package kg.attractor.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "albums")
@Data
@CompoundIndex(def = "{'title': 1, 'produceDate': 1}")
public class Album {
    @Id
    private String id;
    private String title;
    private LocalDate produceDate;
    @DBRef
    private List<Song> songs = new ArrayList<>();
    private List<Singer> singers = new ArrayList<>();

    public List<Song> getSongs() {
        return songs;
    }

    public Album(String id, String title, LocalDate produceDate, List<Song> songs, List<Singer> singers) {
        this.id = id;
        this.title = title;
        this.produceDate = produceDate;
        this.songs = songs;
        this.singers = singers;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProduceDate() {
        return produceDate;
    }

    public void setProduceDate(LocalDate produceDate) {
        this.produceDate = produceDate;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }




}
