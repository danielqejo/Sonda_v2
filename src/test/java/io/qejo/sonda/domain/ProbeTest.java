package io.qejo.sonda.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProbeTest {

    private static final String PROBE_NAME = "Sputnik";

    @Mock
    private Coordinates coordinates;

    @Test
    void move_shouldCallPlusYWhenPoitingNorth() {
        Probe subject = new Probe(PROBE_NAME, coordinates, Direction.N);

        subject.move();

        verify(coordinates).plusY();
    }

    @Test
    void move_shouldCallMinusYWhenPoitingSouth() {
        Probe subject = new Probe(PROBE_NAME, coordinates, Direction.S);

        subject.move();

        verify(coordinates).minusY();
    }

    @Test
    void move_shouldCallMinusXWhenPoitingWest() {
        Probe subject = new Probe(PROBE_NAME, coordinates, Direction.W);

        subject.move();

        verify(coordinates).minusX();
    }

    @Test
    void move_shouldCallPlusXWhenPoitingEast() {
        Probe subject = new Probe(PROBE_NAME, coordinates, Direction.E);

        subject.move();

        verify(coordinates).plusX();
    }

}
