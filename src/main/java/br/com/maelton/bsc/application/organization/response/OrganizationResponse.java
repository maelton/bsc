package br.com.maelton.bsc.application.organization.response;

import java.util.List;
import java.util.UUID;

import br.com.maelton.bsc.domain.organization.entity.Organization;

public record OrganizationResponse(
    UUID id,
    String name,
    String mission,
    String vision,
    List<String> values
) {
    public static OrganizationResponse from(Organization organization) {
        return new OrganizationResponse(
            organization.getId().value(),
            organization.getName(),
            organization.getMission(),
            organization.getVision(),
            organization.getValues()
        );
    }
}
