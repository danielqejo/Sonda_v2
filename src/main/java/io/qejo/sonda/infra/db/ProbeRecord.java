package io.qejo.sonda.infra.db;

import io.qejo.sonda.domain.Coordinates;
import io.qejo.sonda.domain.Direction;
import io.qejo.sonda.domain.Plateau;
import io.qejo.sonda.domain.Probe;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("probes")
record ProbeRecord(@Id String name, String plateauName, Character direction, Integer positionX, Integer positionY) {

    Probe toEntity() {
        return new Probe(name, new Coordinates(positionX, positionY), Direction.valueOf(direction.toString()));
    }

    static ProbeRecord fromEntity(Plateau plateau, Probe probe) {
        char directionCharacter = probe.getCurrentDirection().name().charAt(0);
        return new ProbeRecord(probe.getName(), plateau.getName(), directionCharacter,
                probe.getPositionX(), probe.getPositionY());
    }

}
