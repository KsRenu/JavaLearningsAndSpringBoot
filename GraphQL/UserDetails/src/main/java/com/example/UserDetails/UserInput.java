package com.example.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class UserInput {
    private String id;
    private String name;
    private String mail;
    private String company;
    private String website;
    private String status;


    public UserInput() {
    }

    public User getUserEntity() {
        User u = new User();
        u.setId(this.id);
        u.setName(this.name);
        u.setMail(this.mail );
        u.setCompany(this.company);
        u.setWebsite(this.website);
        u.setStatus(this.status);
        return u;
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
