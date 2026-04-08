package br.com.maelton.bsc.application.organization.usecase;

import br.com.maelton.bsc.application.organization.port.in.CreateOrganizationUseCase;
import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.domain.organization.entity.Organization;

public class CreateOrganizationService implements CreateOrganizationUseCase {
    private final OrganizationRepository saveOrgPort;

    public CreateOrganizationService(OrganizationRepository saveOrgPort) {
        this.saveOrgPort = saveOrgPort;
    }

    @Override
    public void create(String name) {
        Organization org = new Organization(name);
        saveOrgPort.save(org);
    }
    
}
