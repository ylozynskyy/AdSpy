package com.lozic.adspy.data.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.FetchType.EAGER;

/**
 * The persistent class representing user in system.
 * 
 */
@Entity
@Table(name = "users")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String password;
    private String username;
    private List<Role> roles;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // uni-directional One-to-many association to Role
    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "id")
    @JoinTable(name = "user_roles", inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}