package br.com.maelton.bsc.infrastructure.adapter.out.persistence;

import br.com.maelton.bsc.application.port.out.SaveOrganizationPort;
import br.com.maelton.bsc.domain.entity.Organization;

public class OrganizationPersistenceAdapter implements SaveOrganizationPort {
    private final SpringDataOrganizationJpaRepository repository;

    public OrganizationPersistenceAdapter(
        SpringDataOrganizationJpaRepository repository) {
            this.repository = repository;
        }

    @Override
    public void save(Organization organization) {
        repository.save(OrganizationMapper.toJpaEntity(organization));
        
    }
    
}
