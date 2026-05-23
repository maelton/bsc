package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import org.springframework.stereotype.Component;

import br.com.maelton.bsc.application.organization.command.CreateUpdateOrganizationCommand;
import br.com.maelton.bsc.application.organization.command.PatchOrganizationCommand;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateUpdateOrganizationDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.PatchOrganizationDto;

@Component
public final class OrganizationWebMapper {

    public CreateUpdateOrganizationCommand toCreateUpdateOrganizationCommand(CreateUpdateOrganizationDto dto) {
        return new CreateUpdateOrganizationCommand(
            dto.name(),
            dto.mission(),
            dto.vision(),
            dto.values()
        );
    }

    public PatchOrganizationCommand toPatchOrganizationCommand(PatchOrganizationDto dto) {
        return new PatchOrganizationCommand(
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
