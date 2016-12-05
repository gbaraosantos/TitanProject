package com.baronhub.titan.project.components.models.user;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User Model
 */
@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name="state", nullable=false)
    private String state;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UserPermissions",
            joinColumns = { @JoinColumn(name = "UserId") },
            inverseJoinColumns = { @JoinColumn(name = "PermissionId") })
    private Set<Permissions> userPermissions = new HashSet<>();

    public String getState() { return state; }
    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Set<Permissions> getUserPermissions() { return userPermissions; }

    public User setEmail(String email) { this.email = email; return this; }
    public User setPassword(String password) { this.password = password; return this; }
    public User setState(String state) { this.state = state; return this; }

    /**
     * How to print this object
     * @return String
     */

    @Override
    public String toString(){
        return "User [Id="              + this.getId()           +
                ", Email="              + this.getEmail()        +
                ", Password="           + this.getPassword()     +   "]";
    }

    /**
     * Compares two objects to check if they are the same object
     * @param b Object to compare
     * @return boolean
     */

    @Override
    public boolean equals(Object b){
        User other;

        if (this == b)  return true;
        if (b == null) return false;
        if (!(b instanceof User)) return false;

        other = (User) b;

        return  other.getEmail().equals(this.getEmail())         &&
                other.getPassword().equals(this.getPassword())   &&
                other.getId() == this.getId();


    }

    /**
     * Overrides hashCode
     * @return Int
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null)  ? 0 : email.hashCode());
        return result;
    }



}
