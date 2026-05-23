package br.com.maelton.bsc.application.organization.port.out;

import java.util.List;
import java.util.Optional;

import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public interface OrganizationRepository {
    Organization save(Organization organization);
    Optional<Organization> findById(OrganizationId id);
    List<Organization> findAll();
    void deleteById(OrganizationId id);
}
