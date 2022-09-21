package io.qejo.sonda.domain;

public enum Direction {
    N() {
        @Override
        Direction leftDirection() {
            return W;
        }

        @Override
        Direction rightDirection() {
            return E;
        }
    },
    E {
        @Override
        Direction leftDirection() {
            return N;
        }

        @Override
        Direction rightDirection() {
            return S;
        }
    },
    S {
        @Override
        Direction leftDirection() {
            return E;
        }

        @Override
        Direction rightDirection() {
            return W;
        }
    },
    W {
        @Override
        Direction leftDirection() {
            return S;
        }

        @Override
        Direction rightDirection() {
            return N;
        }
    };

    abstract Direction leftDirection();
    abstract Direction rightDirection();

}
