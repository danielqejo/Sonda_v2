package io.qejo.sonda.domain;

import java.util.List;

public class CommandCenter {

    private final Plateau plateau;
    private final Probe probe;

    public CommandCenter(Plateau plateau, Probe probe) {
        this.plateau = plateau;
        this.probe = probe;
    }

    public CommandCenter act(final List<Action> actions){
        Probe copyOfProbe = probe;
        for (Action action : actions) {
            copyOfProbe = switch(action) {
                case L -> copyOfProbe.turnLeft();
                case R -> copyOfProbe.turnRight();
                case M -> copyOfProbe.move();
            };
        }
        return new CommandCenter(this.plateau, copyOfProbe);
    }

    public Probe getProbe() {
        return this.probe;
    }

    public Plateau getPlateau() {
        return this.plateau;
    }
}
