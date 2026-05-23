package br.com.maelton.bsc.application.organization.port.in;

import java.util.List;

import br.com.maelton.bsc.application.organization.command.CreateUpdateOrganizationCommand;
import br.com.maelton.bsc.application.organization.command.PatchOrganizationCommand;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public interface ManageOrganizationUseCase {
    OrganizationResponse create(CreateUpdateOrganizationCommand command);
    OrganizationResponse findById(OrganizationId id);
    List<OrganizationResponse> findAll();
    OrganizationResponse updateById(OrganizationId id, CreateUpdateOrganizationCommand command);
    OrganizationResponse patchById(OrganizationId id, PatchOrganizationCommand command);
    void deleteById(OrganizationId id);
}
