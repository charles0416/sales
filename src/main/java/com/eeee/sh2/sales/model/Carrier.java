package com.eeee.sh2.sales.model;

import javax.persistence.Entity;

/**
 * Created by Charles on 28/07/2017.
 */
@Entity
public class Carrier extends PersistentObject {

    private String address;
    private String name;
    private String phone;
    private double pricePerKg;
    private boolean isAgent;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public boolean isAgent() {
        return isAgent;
    }

    public void setAgent(boolean agent) {
        isAgent = agent;
    }

    public Carrier() {
    }


}
