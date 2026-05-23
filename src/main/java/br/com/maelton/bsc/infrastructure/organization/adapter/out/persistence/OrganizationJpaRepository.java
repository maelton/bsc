package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface OrganizationJpaRepository extends ListCrudRepository<OrganizationEntity, Long> {
    Optional<OrganizationEntity> findByUuid(UUID uuid);
    void deleteByUuid(UUID id);
}
