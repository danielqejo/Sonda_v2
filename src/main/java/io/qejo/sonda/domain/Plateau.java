package io.qejo.sonda.domain;

public class Plateau {

    private final String name;
    private final Coordinates maximumSize;

    public Plateau(String name, Coordinates maximumSize) {
        this.name = name;
        this.maximumSize = maximumSize;
    }

    public String getName() {
        return name;
    }

    public Coordinates getMaximumSize() {
        return maximumSize;
    }

    @Override
    public String toString() {
        return "Plateau{" +
                "maximumSize=" + maximumSize +
                '}';
    }
}
