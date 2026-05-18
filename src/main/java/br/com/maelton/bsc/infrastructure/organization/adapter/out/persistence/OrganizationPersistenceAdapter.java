package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

@Repository
public class OrganizationPersistenceAdapter implements OrganizationRepository {
    private final OrganizationJpaRepository jpaRepository;
    private final OrganizationEntityMapper orgMapper;

    OrganizationPersistenceAdapter(
        OrganizationJpaRepository springRepository,
        OrganizationEntityMapper orgMapper
    ) {
        this.jpaRepository = springRepository;
        this.orgMapper = orgMapper;
    }

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity orgEntity = jpaRepository.save(
            orgMapper.toJpaEntity(organization)
        );
        
        return orgMapper.toDomain(orgEntity);
    }

    @Override
    public Organization getById(OrganizationId id) {
        Optional<OrganizationEntity> org = jpaRepository.findById(id.value());
    }

}
