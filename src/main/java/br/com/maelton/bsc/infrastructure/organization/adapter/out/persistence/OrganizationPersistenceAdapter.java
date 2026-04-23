package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import br.com.maelton.bsc.application.organization.port.out.OrganizationRepository;
import br.com.maelton.bsc.domain.organization.entity.Organization;

@Repository
public class OrganizationPersistenceAdapter implements OrganizationRepository {
    private final JpaRepository springRepository;
    private final OrganizationMapper orgMapper;

    OrganizationPersistenceAdapter(
        JpaRepository springRepository,
        OrganizationMapper orgMapper
    ) {
        this.springRepository = springRepository;
        this.orgMapper = orgMapper;
    }

    @Override
    public Organization save(Organization organization) {
        OrganizationEntity orgEntity = springRepository.save(
            orgMapper.toJpaEntity(organization)
        );
        
        return orgMapper.toDomain(orgEntity);
    }

}
