package dev.cigana.teste_dws.domain.band;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Band {

    public String id;
    public String name;
    public String image;
    public String genre;
    public String biography;
    public Integer numPlays;
    public List<String>  albums;

}
