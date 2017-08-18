package com.eeee.sh2.sales.model;

import javax.persistence.Entity;

/**
 * Created by Charles on 28/07/2017.
 */
@Entity
public class Commodity extends PersistentObject {

    private String brand;
    private String model;
    private String name;
    private String remark;

    public Commodity() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
