package dev.cigana.teste_dws.domain.enums;

import dev.cigana.teste_dws.domain.band.Band;

import java.util.Comparator;
import java.util.List;

public enum SortBands {

    ORDEM_ALFABETICA {
        @Override
        public List<Band> sort(List<Band> bands) {
            return bands.stream().sorted(Comparator.comparing(Band::getName)).toList();
        }
    },

    POPULARIDADE {
        @Override
        public List<Band> sort(List<Band> bands) {
            return bands.stream().sorted(Comparator.comparing(Band::getNumPlays).reversed()).toList();
        }
    };

    public abstract List<Band> sort(List<Band> bands);

}
