package com.models;


//JPA - Java Persistence API
//This API allows us access to annotations that can map our fields
// to database columns and constraints

import javax.persistence.*;

@Entity //Used to mark a class as a 'Mapped class/Persistence class'
@Table(name="crimes") // now the table will show up in the db as 'crimes'
public class Crime {

    @Id // this specifies this fields as the primary key
    @Column(name = "crime_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //equivalent to the SERIAL keyword
    private int crimeId;

    @Column(name = "crime_name",unique = true, nullable = false) //this is the same as saying UNIQUE, NOT NULL
    private String crimeName;

    //here we wont add any annotation but this column will still appear int th db as 'description'
    private String description;

    public Crime(){
        super();

    }

//used for creating or adding to the db
    public Crime(String crimeName, String description) {
        super();
        this.crimeName = crimeName;
        this.description = description;
    }

//used for retrieving from the db
    public Crime(int crimeId, String crimeName, String description) {
        super();
        this.crimeId = crimeId;
        this.crimeName = crimeName;
        this.description = description;
    }

    public int getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(int crimeId) {
        this.crimeId = crimeId;
    }

    public String getCrimeName() {
        return crimeName;
    }

    public void setCrimeName(String crimeName) {
        this.crimeName = crimeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Crime [crimeId=" + crimeId + ", crimeName=" + crimeName + ", description=" + description + "]";
    }


}
