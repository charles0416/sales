package com.eeee.sh2.sales.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Charles on 28/07/2017.
 */
@Entity
public class Carrier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;
    private String name;
    private String phone;
    private double pricePerKg;
    private boolean isAgent;

    public Carrier() {
    }


}
