package io.qejo.sonda.domain;

public class PlateauNotFoundException extends RuntimeException {

    public PlateauNotFoundException(String plateauName) {
        super("No such Plateau: %s".formatted(plateauName));
    }
}
