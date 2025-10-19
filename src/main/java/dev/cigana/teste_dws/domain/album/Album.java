package dev.cigana.teste_dws.domain.album;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cigana.teste_dws.domain.band.Band;
import dev.cigana.teste_dws.domain.track.Track;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    public String name;
    public String id;
    public String releasedDate;
    public String image;

    @JsonIgnore
    public Band band;
    public List<Track> tracks;

}
