package dev.cigana.teste_dws.services;

import dev.cigana.teste_dws.domain.track.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class TrackService {

    @Autowired
    private WebClient webClient;

    public Track getTrackById(String id){
        Mono<Track> bandResponse = webClient.get()
                .uri("api/tracks/{id}", id)
                .retrieve()
                .bodyToMono(Track.class);
        return bandResponse.block();
    }

}
