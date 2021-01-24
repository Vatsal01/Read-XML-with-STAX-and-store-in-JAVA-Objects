package com.company;

public class PersonalDetails {
    int id;


    String name ;
    String surname;
    String homeaddresss ;
    String contact ;
    String job ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHomeaddresss() {
        return homeaddresss;
    }

    public void setHomeaddresss(String homeaddresss) {
        this.homeaddresss = homeaddresss;
    }



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
