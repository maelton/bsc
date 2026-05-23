package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.List;
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
        OrganizationJpaRepository jpaRepository,
        OrganizationEntityMapper orgMapper
    ) {
        this.jpaRepository = jpaRepository;
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
    public Optional<Organization> findById(OrganizationId id) {
        Optional<OrganizationEntity> optional = jpaRepository.findByUuid(id.value());
        return optional.map(entity -> orgMapper.toDomain(entity));
    }

    @Override
    public List<Organization> findAll() {
        List<OrganizationEntity> entities = jpaRepository.findAll();
        
        return entities.stream()
                        .map(entity -> orgMapper.toDomain(entity))
                        .toList();
    }

    @Override
    public void deleteById(OrganizationId id) {
        jpaRepository.deleteByUuid(id.value());
    }
}
