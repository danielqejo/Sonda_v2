package io.qejo.sonda.domain;

public record Coordinates(int x, int y){

    Coordinates plusX(){
        return new Coordinates(x+1, y);
    }
    Coordinates minusX(){
        return new Coordinates(x-1, y);
    }
    Coordinates plusY(){
        return new Coordinates(x, y+1);
    }
    Coordinates minusY(){
        return new Coordinates(x, y-1);
    }
}
