package br.com.maelton.bsc.application.organization.port.out;

import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public interface OrganizationRepository {
    Organization save(Organization organization);
    Organization getById(OrganizationId id);
}
