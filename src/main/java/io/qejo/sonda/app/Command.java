package io.qejo.sonda.app;

import io.qejo.sonda.domain.Action;

import java.util.List;

public record Command(String plateauName, String probeName, List<Action> actions) {
}
