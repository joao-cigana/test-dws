package dev.cigana.teste_dws.services;

import dev.cigana.teste_dws.domain.band.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BandService {

    @Autowired
    private WebClient webClient;

    public List<Band> getBands(String bandName){
        Flux<Band> bandsResponse = webClient.get()
                .uri("api/bands")
                .retrieve()
                .bodyToFlux(Band.class);
        List<Band> list = bandsResponse.collectList().block();
        if(bandName!= null && !bandName.isBlank()){
            list = list.stream().filter(b -> b.name.toUpperCase().contains(bandName.toUpperCase())).toList();
        }
        return list;
    }

    public Band getBandById(String id){
        Mono<Band> bandResponse = webClient.get()
                .uri("api/bands/{id}", id)
                .retrieve()
                .bodyToMono(Band.class);
        return bandResponse.block();
    }

}
