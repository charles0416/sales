package com.eeee.sh2.sales.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Charles on 8/18/2017.
 */
@MappedSuperclass
public abstract class PersistentObject implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PersistentObject)) {
            return false;
        }
        final PersistentObject other = (PersistentObject) obj;
        if (this.id != null && other.id != null) {
            if (this.id != other.id) {
                return false;
            }
        }
        return true;
    }


    @PrePersist
    protected void onCreate() {
        lastUpdate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdate = new Date();
    }

}
