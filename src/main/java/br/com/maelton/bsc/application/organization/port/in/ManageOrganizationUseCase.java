package br.com.maelton.bsc.application.organization.port.in;

import br.com.maelton.bsc.application.organization.command.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public interface ManageOrganizationUseCase {
    OrganizationResponse create(CreateOrganizationCommand command);
    OrganizationResponse readById(OrganizationId id);
}
