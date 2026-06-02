package br.com.maelton.bsc.application.organization.port.out;

import java.util.List;
import java.util.Optional;

import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public interface OrganizationRepository {
    Organization create(Organization organization);
    Optional<Organization> findById(OrganizationId id);
    List<Organization> findAll();
    Organization update(Organization organization);
    void deleteById(OrganizationId id);
}
