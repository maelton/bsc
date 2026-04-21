package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;

public interface JpaRepository extends CrudRepository<OrganizationEntity, Long> {

}
