package br.com.maelton.bsc.infrastructure.organization.adapter.in.web;

import org.springframework.stereotype.Component;

import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationResult;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.CreateOrganizationRequestDto;
import br.com.maelton.bsc.infrastructure.organization.adapter.in.web.dto.OrganizationResponseDto;

@Component
public final class OrganizationWebMapper {

    public CreateOrganizationCommand toCreateOrganizationCommand(CreateOrganizationRequestDto dto) {
        return new CreateOrganizationCommand(
            dto.name(),
            dto.mission(),
            dto.vision(),
            dto.values()
        );
    }

    public OrganizationResponseDto toOrganizationResponseDto(
        CreateOrganizationResult createResult
    ) {
        return new OrganizationResponseDto(
            createResult.id().value(),
            createResult.name(),
            createResult.mission(),
            createResult.vision(),
            createResult.values()
        );
    }
    
}
