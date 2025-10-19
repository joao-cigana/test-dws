package dev.cigana.teste_dws.controllers;

import dev.cigana.teste_dws.domain.band.Band;
import dev.cigana.teste_dws.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
@CrossOrigin
public class BandController {

    @Autowired
    private BandService bandService;

    @GetMapping()
    public ResponseEntity<List<Band>> findAllBands(@RequestParam(required = false) String name){
        return ResponseEntity.ok(bandService.getBands(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Band> findBandById(@PathVariable("id") String id){
        return ResponseEntity.ok(bandService.getBandById(id));
    }

}
