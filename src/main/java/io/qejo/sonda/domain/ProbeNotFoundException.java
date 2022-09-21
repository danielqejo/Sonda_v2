package io.qejo.sonda.domain;

public class ProbeNotFoundException extends IllegalArgumentException {

    public ProbeNotFoundException(String probeName) {
        super("No such Probe: %s".formatted(probeName));
    }

}
