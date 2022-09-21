package io.qejo.sonda.ui;

import io.qejo.sonda.app.Command;
import io.qejo.sonda.app.CommandCenterService;
import io.qejo.sonda.app.IssueCommandResult;
import io.qejo.sonda.domain.Action;
import io.qejo.sonda.domain.Probe;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping(path = "/plateau/{plateauName}/probes")
class ProbeController {

    private final CommandCenterService commandCenterService;

    ProbeController(CommandCenterService commandCenterService) {
        this.commandCenterService = commandCenterService;
    }

    @PatchMapping(path = "{probeName}/command", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> command(
            @PathVariable @NotBlank String plateauName,
            @PathVariable @Positive String probeName,
            @RequestBody List<@Pattern(regexp = "^[LMR]$") String> stringCommands) {
        List<Action> actions = convert(stringCommands);

        IssueCommandResult commandResult =
                commandCenterService.issue(new Command(plateauName, probeName, actions));

        return switch (commandResult) {
            case IssueCommandResult.SuccessIssueCommandResult s ->
                ResponseEntity.ok(convert(plateauName, s.commandedProbe));
            case IssueCommandResult.FailureIssueCommandResult f ->
                ResponseEntity.badRequest().body(f.errorMessage);
            default -> ResponseEntity.internalServerError().body("Something gone really wrong");
        };
    }

    private List<Action> convert(List<String> stringCommands) {
        return stringCommands.stream()
                .map(Action::valueOf)
                .toList();
    }

    private ProbeCommandedDTO convert(String plateauName, Probe probe) {
        ProbeCommandedDTO.PositionDTO positionDTO = new ProbeCommandedDTO.PositionDTO(probe.getPositionX(), probe.getPositionY());
        return new ProbeCommandedDTO(plateauName, probe.getName(), positionDTO);
    }

}
