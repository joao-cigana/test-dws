package dev.cigana.teste_dws.services;

import dev.cigana.teste_dws.domain.album.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AlbumService {

    @Autowired
    private WebClient webClient;

    public Album getAlbumById(String id){
        Mono<Album> bandResponse = webClient.get()
                .uri("api/albums/{id}", id)
                .retrieve()
                .bodyToMono(Album.class);
        return bandResponse.block();
    }

}
