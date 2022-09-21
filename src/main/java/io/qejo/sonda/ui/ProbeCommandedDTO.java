package io.qejo.sonda.ui;

public record ProbeCommandedDTO(String probePlateau, String probeName, PositionDTO currentPosition) {

    record PositionDTO(int x, int y){}

}
