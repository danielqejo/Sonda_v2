package io.qejo.sonda.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectionTest {

    @Test
    void shouldReturnNorthWhenIsLeftDirectionOfEast() {
        assertEquals(Direction.N, Direction.E.leftDirection());
    }

    @Test
    void shouldReturnSouthWhenIsRightDirectionOfEast() {
        assertEquals(Direction.S, Direction.E.rightDirection());
    }

    @Test
    void shouldReturnWestWhenIsLeftDirectionOfNorth() {
        assertEquals(Direction.W, Direction.N.leftDirection());
    }

    @Test
    void shouldReturnEastWhenIsRightDirectionOfNorth() {
        assertEquals(Direction.E, Direction.N.rightDirection());
    }

    @Test
    void shouldReturnEastWhenIsLeftDirectionOfSouth() {
        assertEquals(Direction.E, Direction.S.leftDirection());
    }

    @Test
    void shouldReturnWestWhenIsRightDirectionOfSouth() {
        assertEquals(Direction.W, Direction.S.rightDirection());
    }

    @Test
    void shouldReturnSouthWhenIsLeftDirectionOfWest() {
        assertEquals(Direction.S, Direction.W.leftDirection());
    }

    @Test
    void shouldReturnNorthWhenIsRightDirectionOfWest() {
        assertEquals(Direction.N, Direction.W.rightDirection());
    }
}
