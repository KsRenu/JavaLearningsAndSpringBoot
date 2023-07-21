package com.example.UserDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String mail;
    @Column
    private String company;
    @Column
    private String website;
    @Column
    private String status;


    public User() {
    }

    public User(String id, String name, String mail, String company, String website, String status) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.company = company;
        this.website = website;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
