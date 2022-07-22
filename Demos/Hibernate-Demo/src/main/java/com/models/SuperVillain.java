package com.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="super_villains")
public class SuperVillain {

    @Id
    @Column(name = "svill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int svillId;

    @Column(name="svill_name", unique = true, nullable = false)
    private String svillName;

    @Column(name = "super_power")
    private String superPower;


    private double bounty;


    //separate joins table would best describe this relationship
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) //Lazy fetching means that the data
    // wont be loaded into memory until the get crimes method is called
    private List<Crime> crimes;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "prison_fk")
    private SuperPrison superPrison; //this is a foreign key pointing to the prison where this supervillain is

    public SuperVillain() {
        super();
    }

    public SuperVillain(String svillName, String superPower, double bounty, List<Crime> crimes, SuperPrison superPrison) {
        super();
        this.svillName = svillName;
        this.superPower = superPower;
        this.bounty = bounty;
        this.crimes = crimes;
        this.superPrison = superPrison;
    }

    public SuperVillain(int svillId, String svillName, String superPower, double bounty, List<Crime> crimes, SuperPrison superPrison) {
        super();
        this.svillId = svillId;
        this.svillName = svillName;
        this.superPower = superPower;
        this.bounty = bounty;
        this.crimes = crimes;
        this.superPrison = superPrison;
    }

    public int getSvillId() {
        return svillId;
    }

    public void setSvillId(int svillId) {
        this.svillId = svillId;
    }

    public String getSvillName() {
        return svillName;
    }

    public void setSvillName(String svillName) {
        this.svillName = svillName;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public double getBounty() {
        return bounty;
    }

    public void setBounty(double bounty) {
        this.bounty = bounty;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public SuperPrison getSuperPrison() {
        return superPrison;
    }

    public void setSuperPrison(SuperPrison superPrison) {
        this.superPrison = superPrison;
    }

    @Override
    public String toString() {
        return "SuperVillain [svillId=" + svillId + ", svillName=" + svillName + ", superPower=" + superPower
                + ", bounty=" + bounty + ", crimes=" + crimes + "]";
    }

}
