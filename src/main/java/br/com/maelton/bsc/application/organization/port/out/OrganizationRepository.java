package br.com.maelton.bsc.application.organization.port.out;

import br.com.maelton.bsc.domain.organization.entity.Organization;

public interface OrganizationRepository {
    Organization save(Organization organization);
}
