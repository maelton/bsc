package br.com.maelton.bsc.application.usecase;

import br.com.maelton.bsc.application.port.in.CreateOrganizationUseCase;
import br.com.maelton.bsc.application.port.out.SaveOrganizationPort;
import br.com.maelton.bsc.domain.entity.Organization;

public class CreateOrganizationService implements CreateOrganizationUseCase {
    private final SaveOrganizationPort saveOrgPort;

    public CreateOrganizationService(SaveOrganizationPort saveOrgPort) {
        this.saveOrgPort = saveOrgPort;
    }

    @Override
    public void create(String name) {
        Organization org = new Organization(name);
        saveOrgPort.save(org);
    }
    
}
