package io.qejo.sonda.infra.db;

import io.qejo.sonda.domain.Coordinates;
import io.qejo.sonda.domain.Plateau;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("plateaus")
record PlateauRecord(@Id String name, Integer limitX, Integer limitY) {

    Plateau toEntity() {
        return new Plateau(name, new Coordinates(limitX, limitY));
    }

    static PlateauRecord fromEntity(Plateau plateau) {
        Coordinates maximumCoordinates = plateau.getMaximumSize();
        return new PlateauRecord(plateau.getName(), maximumCoordinates.x(), maximumCoordinates.y());
    }

}
