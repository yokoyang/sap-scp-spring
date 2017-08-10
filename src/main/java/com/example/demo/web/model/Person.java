package com.example.demo.web.model;

public class Person {
    private Long personId;
    private String personName;

    public Long getPersonId() {
        return personId;
    }

    public Person() {
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Person(Long personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }
}
