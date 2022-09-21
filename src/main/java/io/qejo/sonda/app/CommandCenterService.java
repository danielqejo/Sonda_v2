package io.qejo.sonda.app;

import io.qejo.sonda.domain.CommandCenter;
import io.qejo.sonda.domain.CommandCenterRepository;
import io.qejo.sonda.app.IssueCommandResult.FailureIssueCommandResult;
import io.qejo.sonda.app.IssueCommandResult.SuccessIssueCommandResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CommandCenterService {

    private final CommandCenterRepository repository;

    CommandCenterService(CommandCenterRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public IssueCommandResult issue(Command command) {
        Optional<CommandCenter> result =
                repository.findWith(command.plateauName(), command.probeName());

        if (result.isEmpty())
            return new FailureIssueCommandResult(command.probeName());

        CommandCenter foundCommandCenter = result.get();
        CommandCenter mutatedCommandCenter = foundCommandCenter.act(command.actions());

        repository.save(mutatedCommandCenter);

        return new SuccessIssueCommandResult(mutatedCommandCenter.getProbe());
    }

}
