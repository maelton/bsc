package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.maelton.bsc.domain.organization.entity.Organization;
import br.com.maelton.bsc.domain.organization.entity.OrganizationId;

@Component
public class OrganizationEntityMapper {
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
        Set<String> orgValues = jpaEntity.getValues()
                                .stream()
                                .map(OrganizationValueEntity::getText)
                                .collect(Collectors.toSet());
        
        return new Organization(
            new OrganizationId(jpaEntity.getUuid()),
            jpaEntity.getName(),
            jpaEntity.getMission(),
            jpaEntity.getVision(),
            orgValues
        );
    }
}
