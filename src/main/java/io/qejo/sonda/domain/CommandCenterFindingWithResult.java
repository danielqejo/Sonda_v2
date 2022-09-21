package io.qejo.sonda.domain;

public sealed abstract class CommandCenterFindingWithResult {

    public final class ProbeNotFoundCommandCenterFindingResult extends CommandCenterFindingWithResult {
        public final String message;

        ProbeNotFoundCommandCenterFindingResult(String probeName) {
            this.message = "No such Probe: %s".formatted(probeName);
        }
    }

    public final class SuccessCommandCenterFindingResult extends CommandCenterFindingWithResult {

        public final CommandCenter commandCenter;

        SuccessCommandCenterFindingResult(CommandCenter commandCenter) {
            this.commandCenter = commandCenter;
        }
    }

}
