package br.com.maelton.bsc.application.organization.command;

import java.util.Objects;
import java.util.Set;

public record CreateUpdateOrganizationCommand(
    String name,
    String mission,
    String vision,
    Set<String> values
) {
    public CreateUpdateOrganizationCommand {
        Objects.requireNonNull(name, "Organization name is required.");
        if(name.trim().length() <= 0) {
            throw new IllegalArgumentException(
                "Organization name cannot be blank."
            );
        }
    }
}
