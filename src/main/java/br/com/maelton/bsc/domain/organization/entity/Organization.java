package br.com.maelton.bsc.domain.organization.entity;

import java.util.Set;
import java.util.UUID;

public class Organization {
    private OrganizationId id;
    private String name;
    private String mission;
    private String vision;
    private Set<String> values;

    public String getMission() {
        return mission;
    }

    public String getVision() {
        return vision;
    }

    public Set<String> getValues() {
        return values;
    }

    public OrganizationId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Organization(
        OrganizationId id, 
        String name,
        String mission,
        String vision,
        Set<String> values
    ) {
        this.id = id;
        this.name = name;
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }

    public Organization(
        String name,
        String mission,
        String vision,
        Set<String> values
    ) {
        id = OrganizationId.generate();
        this.name = name;
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }
}
