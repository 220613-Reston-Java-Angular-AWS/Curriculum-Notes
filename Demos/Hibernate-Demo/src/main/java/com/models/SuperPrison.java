package com.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "super_prison")
public class SuperPrison {

    @Id
    @Column(name = "sp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int spId;

    @Column(name = "sp_name")
    private String name;

    @Column(nullable = false)
    private String location;



    //This lists the many villains whoseforeign key points to this superPrisons primary key
    @OneToMany(mappedBy = "superPrison",fetch = FetchType.LAZY)
    private List<SuperVillain> villains = new ArrayList<SuperVillain>();

    public SuperPrison() {
        super();
    }
public SuperPrison(String name,String location){
        super();
        this.name = name;
        this.location = location;
}
    public SuperPrison(String name, String location, List<SuperVillain> villains) {
        super();
        this.name = name;
        this.location = location;
        this.villains = villains;
    }

    public SuperPrison(int spId, String name, String location, List<SuperVillain> villains) {
        this.spId = spId;
        this.name = name;
        this.location = location;
        this.villains = villains;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<SuperVillain> getVillains() {
        return villains;
    }

    public void setVillains(List<SuperVillain> villains) {
        this.villains = villains;
    }

    @Override
    public String toString() {
        return "SuperPrison [spId=" + spId + ", name=" + name + ", location=" + location + ", villains=" + villains
                + "]";
    }

}
