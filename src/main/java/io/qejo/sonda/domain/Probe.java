package io.qejo.sonda.domain;

public class Probe {

    private final String name;
    private final Coordinates currentPosition;
    private final Direction currentDirection;

    public Probe(String name, Coordinates startingPosition, Direction currentDirection) {
        this.name = name;
        this.currentPosition = startingPosition;
        this.currentDirection = currentDirection;
    }

    public Probe turnLeft() {
        return new Probe(this.name, this.currentPosition, currentDirection.leftDirection());
    }

    public Probe turnRight() {
        return new Probe(this.name, this.currentPosition, currentDirection.rightDirection());
    }

    public Probe move() {
        return switch(this.currentDirection) {
            case N -> new Probe(this.name, this.currentPosition.plusY(), this.currentDirection);
            case E -> new Probe(this.name, this.currentPosition.plusX(), this.currentDirection);
            case S -> new Probe(this.name, this.currentPosition.minusY(), this.currentDirection);
            case W -> new Probe(this.name, this.currentPosition.minusX(), this.currentDirection);
        };
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public int getPositionX() {
        return currentPosition.x();
    }

    public int getPositionY() {
        return currentPosition.y();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Probe{");
        sb.append("name='").append(name).append('\'');
        sb.append(", currentPosition=").append(currentPosition);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return this.name;
    }
}
