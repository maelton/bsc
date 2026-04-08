package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationSpringJpaRepository extends JpaRepository<OrganizationJpaEntity, Long> {

}
