package dev.cigana.teste_dws.controllers;

import dev.cigana.teste_dws.domain.album.Album;
import dev.cigana.teste_dws.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/{id}")
    public ResponseEntity<Album> findAlbumById(@PathVariable("id") String id){
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }

}
