package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="tb_organization",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_organization_name",
            columnNames = { "name" }
        ),
        @UniqueConstraint(
            name = "uq_organization_uuid",
            columnNames = { "uuid" }
        )
    }
)
@NoArgsConstructor
@Getter
public class OrganizationEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(nullable = false, updatable=false)
    private UUID uuid;

    @Column(nullable=false) @NotBlank
    private String name;
    private String mission;
    private String vision;

    @OneToMany(
        mappedBy = "organization", 
        orphanRemoval = true,
        cascade = CascadeType.ALL
    )
    private Set<OrganizationValueEntity> values = new HashSet<>();

    public void setValues(Set<OrganizationValueEntity> values) {
        this.values = values;
    }

    public void addValue(OrganizationValueEntity value) {
        values.add(value);
    }

    public OrganizationEntity(
        UUID uuid,
        String name,
        String mission,
        String vision
    ) {
        this.uuid = uuid;
        this.name = name;
        this.mission = mission;
        this.vision = vision;
    }
}
