package br.com.maelton.bsc.application.organization.port.in;

import java.util.Set;

public record CreateOrganizationCommand(
    String name,
    String mission,
    String vision,
    Set<String> values
) {}
