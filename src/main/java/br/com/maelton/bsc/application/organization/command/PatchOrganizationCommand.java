package br.com.maelton.bsc.application.organization.command;

import java.util.Set;

public record PatchOrganizationCommand(
    String name,
    String mission,
    String vision,
    Set<String> values
) {
    
}
