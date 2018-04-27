package com.sainz.onetomanyresume;

//This is the parent

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    @OneToMany(mappedBy = "onePerson")
    Set<Experience> myExperiences;

    public Person() {
        myExperiences = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Experience> getMyExperiences() {
        return myExperiences;
    }

    public void setMyExperiences(Set<Experience> myExperiences) {
        this.myExperiences = myExperiences;
    }
}

