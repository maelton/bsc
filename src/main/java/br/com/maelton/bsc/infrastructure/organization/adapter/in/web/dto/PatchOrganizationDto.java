package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.Set;

public record PatchOrganizationDto(
    String name,
    String mission,
    String vision,
    Set<String> values
) {
    
}
