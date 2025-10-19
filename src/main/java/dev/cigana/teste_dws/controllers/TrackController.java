package dev.cigana.teste_dws.controllers;

import dev.cigana.teste_dws.domain.track.Track;
import dev.cigana.teste_dws.services.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
@CrossOrigin
public class TrackController {

    @Autowired
    private TrackService TrackService;

    @GetMapping("/{id}")
    public ResponseEntity<Track> findTrackById(@PathVariable("id") String id){
        return ResponseEntity.ok(TrackService.getTrackById(id));
    }

}
