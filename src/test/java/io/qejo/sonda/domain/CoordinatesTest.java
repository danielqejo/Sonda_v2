package io.qejo.sonda.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinatesTest {

    private final Coordinates subject
            = new Coordinates(1,1);

    @Test
    void shouldMinusY() {
        assertEquals(0, subject.minusY().y());
    }

    @Test
    void shouldMinusX() {
        assertEquals(0, subject.minusX().x());
    }

    @Test
    void shouldPlusY() {
        assertEquals(2, subject.plusY().y());
    }

    @Test
    void shouldPlusX() {
        assertEquals(2, subject.plusX().x());
    }
}
