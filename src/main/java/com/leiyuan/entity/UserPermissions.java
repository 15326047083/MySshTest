package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class UserPermissions {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "roles")
    private String roles;
    @Column(name = "permissions")
    private String permissions;

    public UserPermissions() {

    }

    public UserPermissions(String roles, String permissions) {
        this.roles = roles;
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserPermissions{" +
                "id='" + id + '\'' +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
