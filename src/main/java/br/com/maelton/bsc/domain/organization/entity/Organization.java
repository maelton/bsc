package br.com.maelton.bsc.domain.organization.entity;

import java.util.HashSet;
import java.util.Set;

import br.com.maelton.bsc.domain.organization.vo.OrganizationName;

public class Organization {
    private OrganizationId id;
    private OrganizationName name;
    private String mission;
    private String vision;
    private Set<String> values;

    public Organization(
        OrganizationId id, 
        String name,
        String mission,
        String vision,
        Set<String> values
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
        Set<String> values
    ) {
        id = OrganizationId.generate();
        this.name = new OrganizationName(name);
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }

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

    public Set<String> getValues() {
        return values;
    }

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public void setValues(Set<String> values) {
        this.values = values;
    }

    public void update(
        OrganizationName name,
        String mission,
        String vision,
        Set<String> values
    ) {
        this.name = name;
        this.mission = mission;
        this.vision = vision;
        this.values = values;
    }

    public void patch(
        String name,
        String mission,
        String vision,
        Set<String> values
    ) {
        if(name != null) this.name = new OrganizationName(name);
        if(mission != null) this.mission = mission;
        if(vision != null) this.vision = vision;
        if(values != null) this.values = new HashSet<>(values);;
    }
}
