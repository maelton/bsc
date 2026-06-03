package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.maelton.bsc.domain.organization.entity.Organization;
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

    public void addValue(OrganizationValueEntity value) {
        value.setOrganization(this);
        values.add(value);
    }

    public void removeValue(OrganizationValueEntity value) {
        values.remove(value);
    }

    public void replaceAllValues(Set<String> newValuesTexts) {
        values.removeIf(
            existingValue -> !newValuesTexts.contains(existingValue.getText())
        );

        Set<String> existingValueTexts = values.stream()
            .map(OrganizationValueEntity::getText)
            .collect(Collectors.toSet());

        for(String newValueText : newValuesTexts) {
            if(!existingValueTexts.contains(newValueText)) {
                OrganizationValueEntity newValue = new OrganizationValueEntity(newValueText, this);
                values.add(newValue);
            }
        }
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

    public void update(Organization organization) {
        this.name = organization.getName();
        this.mission = organization.getMission();
        this.vision = organization.getVision();
        replaceAllValues(organization.getValues());
    }
}
