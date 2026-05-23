package br.com.maelton.bsc.application.organization.command;

import java.util.List;

public record PatchOrganizationCommand(
    String name,
    String mission,
    String vision,
    List<String> values
) {
    
}
