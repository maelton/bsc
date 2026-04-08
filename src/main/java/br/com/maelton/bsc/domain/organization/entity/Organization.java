package br.com.maelton.bsc.domain.organization.entity;

import java.util.UUID;

public class Organization {
    private OrganizationId id;
    private String name;

    public UUID getId() {
        return id.value();
    }

    public String getName() {
        return name;
    }

    public Organization(OrganizationId id, String name) {
        this.id = id;
        this.name = name;
    }

    public Organization(String name) {
        id = OrganizationId.generate();
        this.name = name;
    }
}
