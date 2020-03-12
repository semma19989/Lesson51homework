package kg.attractor.demo.controller;



import kg.attractor.demo.model.Album;
import kg.attractor.demo.model.Singer;
import kg.attractor.demo.repository.AlbumRepo;
import kg.attractor.demo.repository.SingerRepo;
import kg.attractor.demo.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SingerController {
    @Autowired
    private SingerRepo singerRepo;
    @Autowired
    private AlbumRepo albumRepo;
    @Autowired
    private SongRepo songRepo;

    @PostMapping ("/singer")
    public Singer createComment( @RequestBody Singer singer, Album album){
        List<Album> albums= singer.getAlbums();
            /*List<Song> songs= album.getSongs();
          for(Song s:songs)
              songRepo.save(s);*/
        for(Album al:albums)
            albumRepo.save(al);
        singerRepo.save(singer);
        return singer;
    }

    @DeleteMapping ("/singer/{id}")
    public Singer deleteSinger(@PathVariable String id){
        Singer singer= singerRepo.findAllById(id);
        singerRepo.deleteById(id);
        return singer;
    }
    @GetMapping ("/singer/{id}")
    public Singer getSinger(@PathVariable String id){
        Singer singer= singerRepo.findAllById(id);
        return singer;
    }


}