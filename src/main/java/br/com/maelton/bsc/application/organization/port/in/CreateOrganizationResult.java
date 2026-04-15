package br.com.maelton.bsc.application.organization.port.in;

import java.util.Set;

import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public record CreateOrganizationResult(
    OrganizationId id,
    String name,
    String mission,
    String vision,
    Set<String> values
) {}
