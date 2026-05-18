package br.com.maelton.bsc.application.organization.service;

import br.com.maelton.bsc.application.organization.command.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.port.in.ManageOrganizationUseCase;
import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.application.organization.response.OrganizationResponse;
import br.com.maelton.bsc.architecture.annotation.ApplicationService;
import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

@ApplicationService
public class OrganizationService implements ManageOrganizationUseCase {
    private final OrganizationRepository orgRepository;

    public OrganizationService(OrganizationRepository orgRepository) {
        this.orgRepository = orgRepository;
    }

    @Override
    public OrganizationResponse create(CreateOrganizationCommand command) {
        Organization org = new Organization(
            command.name(),
            command.mission(),
            command.vision(),
            command.values()
        );
        Organization saved =  orgRepository.save(org);

        return new OrganizationResponse(
            saved.getId().value(),
            saved.getName(),
            saved.getMission(),
            saved.getVision(),
            saved.getValues()
        );
    }

    @Override
    public OrganizationResponse readById(OrganizationId id) {
        Organization org = orgRepository.getById(id);
        if(org == null) return new OrganizationResponse();

        return new OrganizationResponse(
            org.getId().value(),
            org.getName(),
            org.getMission(),
            org.getVision(),
            org.getValues()
        );
    }
}
