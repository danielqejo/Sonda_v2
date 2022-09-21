package io.qejo.sonda.domain;

import java.util.Optional;

public interface CommandCenterRepository {

    Optional<CommandCenter> findWith(String plateauName, String probeName);

    void save(CommandCenter commandCenter);

}
