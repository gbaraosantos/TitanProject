package com.baronhub.titan.project.components.models.user;

import javax.persistence.*;

/**
 * User Permissions
 */

@Entity
@Table(name="Permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="type", length=15, unique=true, nullable=false)
    private String type;

    public int getId() { return id; }
    public String getType() { return type; }

    public Permissions setType(String type) { this.type = type; return this; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object b) {
        if (this == b) return true;
        if (b == null) return false;
        if (!(b instanceof Permissions)) return false;

        Permissions other = (Permissions) b;

        return  other.getId() == this.getId()               &&
                other.getType().equals(this.getType());
    }

    @Override
    public String toString() {
        return "Permission [id=" + id + ",  type=" + type  + "]";
    }
}
