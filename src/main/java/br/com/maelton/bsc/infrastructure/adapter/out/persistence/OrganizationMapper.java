package br.com.maelton.bsc.infrastructure.adapter.out.persistence;

import br.com.maelton.bsc.domain.entity.Organization;
import br.com.maelton.bsc.domain.entity.OrganizationId;

public final class OrganizationMapper {
    public static Organization toDomain(OrganizationJpaEntity org) {
        return new Organization(
            new OrganizationId(org.getUuid()), 
            org.getName()
        );
    }

    public static OrganizationJpaEntity toJpaEntity(Organization org) {
        return new OrganizationJpaEntity(
            null,
            org.getId(),
            org.getName()
        );
    }
}
