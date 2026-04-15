package br.com.maelton.bsc.application.organization.usecase;

import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationCommand;
import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationResult;
import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationUseCase;
import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.architecture.annotation.ApplicationService;
import br.com.maelton.bsc.domain.organization.entity.Organization;

@ApplicationService
public class OrganizationService implements CreateOrganizationUseCase {
    private final OrganizationRepository orgRepository;

    public OrganizationService(
        OrganizationRepository orgRepository
    ) {
        this.orgRepository = orgRepository;
    }

    @Override
    public CreateOrganizationResult create(CreateOrganizationCommand command) {
        Organization org = new Organization(
            command.name(),
            command.mission(),
            command.vision(),
            command.values()
        );
        
        Organization saved =  orgRepository.save(org);

        return new CreateOrganizationResult(
            saved.getId(),
            saved.getName(),
            saved.getMission(),
            saved.getVision(),
            saved.getValues()
        );
    }
}
