package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.HashSet;
import java.util.Set;

import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

public class OrganizationMapper {
    public OrganizationEntity toJpaEntity(Organization org) {
        OrganizationEntity jpaEntity = new OrganizationEntity(
            org.getId().value(),
            org.getName(),
            org.getMission(),
            org.getVision()
        );
        if(org.getValues() != null && !org.getValues().isEmpty()) {
            for(String value: org.getValues()) {
                jpaEntity.addValue(
                    new OrganizationValueEntity(value, jpaEntity)
                );
            }
        }
        return jpaEntity;
    }

    public Organization toDomain(OrganizationEntity jpaEntity) {
        Set<String> orgValues = new HashSet<>();
        if(jpaEntity.getValues() != null && !jpaEntity.getValues().isEmpty()) {
            for(OrganizationValueEntity value : jpaEntity.getValues()) {
                orgValues.add(value.getText());            }
        }
        
        return new Organization(
            new OrganizationId(jpaEntity.getUuid()),
            jpaEntity.getName(),
            jpaEntity.getMission(),
            jpaEntity.getVision(),
            orgValues
        );
    }
}
