package io.qejo.sonda.infra.db;

import io.qejo.sonda.domain.CommandCenter;
import io.qejo.sonda.domain.CommandCenterRepository;
import io.qejo.sonda.domain.Plateau;
import io.qejo.sonda.domain.Probe;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class CommandCenterRepositoryImpl implements CommandCenterRepository {

    private final PlateauDAO plateauDAO;
    private final ProbeDAO probeDAO;

    CommandCenterRepositoryImpl(PlateauDAO plateauDAO, ProbeDAO probeDAO) {
        this.plateauDAO = plateauDAO;
        this.probeDAO = probeDAO;
    }

    @Override
    public Optional<CommandCenter> findWith(String plateauName, String probeName) {
        Optional<PlateauRecord> plateau = plateauDAO.findById(plateauName);

        return plateau.flatMap(plateauRecord -> probeDAO.findById(probeName))
                        .map(probeRecord -> {
                            Plateau entityPlateau = plateau.get().toEntity();
                            Probe probe = probeRecord.toEntity();
                            return new CommandCenter(entityPlateau, probe);
                        })
                .or(Optional::empty);
    }

    @Override
    public void save(CommandCenter commandCenter) {
        PlateauRecord plateau = PlateauRecord.fromEntity(commandCenter.getPlateau());
        ProbeRecord probe = ProbeRecord.fromEntity(commandCenter.getPlateau(), commandCenter.getProbe());

        plateauDAO.save(plateau);
        probeDAO.save(probe);
    }

}
