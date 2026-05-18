package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import org.springframework.stereotype.Component;

import br.com.maelton.bsc.application.organization.command.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateOrganizationDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;

@Component
public final class OrganizationWebMapper {

    public CreateOrganizationCommand toCreateOrganizationCommand(CreateOrganizationDto dto) {
        return new CreateOrganizationCommand(
            dto.name(),
            dto.mission(),
            dto.vision(),
            dto.values()
        );
    }

    public OrganizationResponseDto toOrganizationResponseDto(OrganizationResponse orgResponse) {
        return new OrganizationResponseDto(
            orgResponse.id(),
            orgResponse.name(),
            orgResponse.mission(),
            orgResponse.vision(),
            orgResponse.values()
        );
    }
    
}
