package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepository extends CrudRepository<OrganizationEntity, Long> {

}
