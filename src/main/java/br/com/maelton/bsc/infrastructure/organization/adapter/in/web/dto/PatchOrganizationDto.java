package br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto;

import java.util.List;

public record PatchOrganizationDto(
    String name,
    String mission,
    String vision,
    List<String> values
) {
    
}
