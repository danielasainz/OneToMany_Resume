package com.sainz.onetomanyresume;

//this is the child

import javax.persistence.*;


@Entity
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String jobTitle;
    private String organizationName;


    @ManyToOne()
    Person onePerson;

    public Experience() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Person getOnePerson() {
        return onePerson;
    }

    public void setOnePerson(Person onePerson) {
        this.onePerson = onePerson;
    }
}