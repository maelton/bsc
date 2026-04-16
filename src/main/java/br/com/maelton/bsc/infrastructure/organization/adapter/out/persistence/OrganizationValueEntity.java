package br.com.maelton.bsc.infrastructure.organization.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(
    name = "tb_organization_value",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "uq_organization_value_per_organization",
            columnNames = {"text", "organization_id"}
        )
    }
)
public class OrganizationValueEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne 
    @JoinColumn(
        name = "organization_id",
        nullable = false
    )
    private OrganizationEntity organization; 
    
    @Column(nullable=false) @NotBlank
    private String text;
}
