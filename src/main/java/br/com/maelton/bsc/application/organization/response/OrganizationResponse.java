package br.com.maelton.bsc.application.organization.response;

import java.util.List;
import java.util.UUID;

public record OrganizationResponse(
    UUID id,
    String name,
    String mission,
    String vision,
    List<String> values
) {
    
}
