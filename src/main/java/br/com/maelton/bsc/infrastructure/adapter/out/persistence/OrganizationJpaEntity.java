package br.com.maelton.bsc.infrastructure.adapter.out.persistence;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name="tb_organization",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "name" }),
        @UniqueConstraint(columnNames = { "uuid" })
    }
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OrganizationJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
}
