package br.com.maelton.bsc.domain.organization.entity;

import java.util.List;

import br.com.maelton.bsc.domain.organization.vo.OrganizationName;

public class Organization {
    private OrganizationId id;
    private OrganizationName name;
    private String mission;
    private String vision;
    private List<String> values;

    public OrganizationId getId() {
        return id;
    }
    
    public String getName() {
        return name.value();
    }
    
    public String getMission() {
        return mission;
    }

    public String getVision() {
        return vision;
    }

    public List<String> getValues() {
        return values;
    }

    public Organization(
        OrganizationId id, 
        String name,
        String mission,
        String vision,
        List<String> values
    ) {
        this.id = id;
        this.name = new OrganizationName(name);
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }

    public Organization(
        String name,
        String mission,
        String vision,
        List<String> values
    ) {
        id = OrganizationId.generate();
        this.name = new OrganizationName(name);
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }
}
