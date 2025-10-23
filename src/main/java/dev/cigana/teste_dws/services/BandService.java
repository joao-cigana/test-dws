package dev.cigana.teste_dws.services;

import dev.cigana.teste_dws.domain.band.Band;
import dev.cigana.teste_dws.domain.enums.SortBands;
import dev.cigana.teste_dws.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class BandService {

    @Autowired
    private WebClient webClient;

    @Cacheable("bands")
    public List<Band> getBands(String bandName, SortBands sort){
        Flux<Band> bandsResponse = webClient.get()
                .uri("api/bands")
                .retrieve()
                .bodyToFlux(Band.class);
        List<Band> list = bandsResponse.collectList().block();
        if(list == null || list.isEmpty()){
            throw new ResourceNotFoundException("Resource not Found");
        }
        if(bandName!= null && !bandName.isBlank()){
            list = list.stream().filter(b -> b.name.toUpperCase().contains(bandName.toUpperCase())).toList();
        }
        if(sort != null){
            list = sort.sort(list);
        }
        return list;
    }

    public Band getBandById(String id){
        Band bandResponse = webClient.get()
                .uri("api/bands/{id}", id)
                .retrieve()
                .bodyToMono(Band.class).block();
        if(bandResponse == null){
            throw new ResourceNotFoundException("Resource not Found");
        }
        return bandResponse;
    }

    @Scheduled(fixedDelay = 600_000)
    @CacheEvict(value = "bands", allEntries = true)
    public void evictBandsCache() {
        System.out.println("Limpando o cache de bandas.");
    }



}
