package com.eeee.sh2.sales.model;

import javax.persistence.Entity;

/**
 * Created by Charles on 28/07/2017.
 */
@Entity
public class Customer extends PersistentObject {

    private String name;

    private String wechatId;

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }
}
