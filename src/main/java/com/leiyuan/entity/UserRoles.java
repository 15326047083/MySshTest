package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 角色表
 */
@Entity
@Table(name = "roles")
public class UserRoles {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //用户的学号
    @Column(name = "studentNum")
    private String studentNum;
    //角色名
    @Column(name = "roles")
    private String roles;

    public UserRoles() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id='" + id + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public UserRoles(String studentNum, String roles) {

        this.studentNum = studentNum;
        this.roles = roles;
    }
}