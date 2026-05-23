package br.com.maelton.bsc.domain.organization.entity;

import java.util.List;

import br.com.maelton.bsc.domain.organization.vo.OrganizationName;

public class Organization {
    private OrganizationId id;
    private OrganizationName name;
    private String mission;
    private String vision;
    private List<String> values;

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

    public void setName(OrganizationName name) {
        this.name = name;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public void update(
        OrganizationName name,
        String mission,
        String vision,
        List<String> values
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
        List<String> values
    ) {
        if(this.name != null) this.name = new OrganizationName(name);
        if(this.mission != null) this.mission = mission;
        if(this.vision != null) this.vision = vision;
        if(this.values != values) this.values = values;
    }
}
