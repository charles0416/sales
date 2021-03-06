package com.eeee.sh2.sales.model;

import javax.persistence.Entity;

/**
 * Created by Charles on 15/06/2017.
 */
@Entity
public class Account extends PersistentObject {

    private String surname;

    private String givenName;

    private String email;

    private String password;

    public Account(String surname, String givenName, String email, String password) {
        this.surname = surname;
        this.givenName = givenName;
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
