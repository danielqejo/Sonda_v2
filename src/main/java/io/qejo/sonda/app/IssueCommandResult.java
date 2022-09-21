package io.qejo.sonda.app;

import io.qejo.sonda.domain.Probe;

public sealed class IssueCommandResult {

    public static final class SuccessIssueCommandResult extends IssueCommandResult {
        public final Probe commandedProbe;
        SuccessIssueCommandResult(Probe commandedProbe) {
            this.commandedProbe = commandedProbe;
        }
    }

    public static final class FailureIssueCommandResult extends IssueCommandResult {
        public final String errorMessage;
        FailureIssueCommandResult(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}
