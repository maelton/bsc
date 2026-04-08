package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.domain.organization.entity.Organization;

public class OrganizationPersistenceAdapter implements OrganizationRepository {
    private final OrganizationSpringJpaRepository repository;

    public OrganizationPersistenceAdapter(
        OrganizationSpringJpaRepository repository) {
            this.repository = repository;
        }

    @Override
    public Organization save(Organization organization) {
        return OrganizationMapper.toDomain(
            repository.save(OrganizationMapper.toJpaEntity(organization))
        );   
    }
}
