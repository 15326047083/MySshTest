package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoles {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "roles")
    private String roles;

    public UserRoles() {
        // TODO Auto-generated constructor stub
    }

    public UserRoles(String id, String email, String roles) {
        //super();
        this.id = id;
        this.email = email;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserRoles [id=" + id + ", email=" + email + ", roles=" + roles + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}