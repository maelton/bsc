package br.com.maelton.bsc.application.organization.command;

import java.util.List;
import java.util.Objects;

public record CreateOrganizationCommand(
    String name,
    String mission,
    String vision,
    List<String> values
) {
    public CreateOrganizationCommand {
        Objects.requireNonNull(name, "Organization name is required.");
        if(name.trim().length() <= 0) {
            throw new IllegalArgumentException(
                "Organization name cannot be blank."
            );
        }
    }
}
