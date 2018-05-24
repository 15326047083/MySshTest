package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 用户表
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //学号
    @Column(name = "num")
    private String num;
    //姓名
    @Column(name = "name")
    private String name;
    //电话
    @Column(name = "phone")
    private String phone;
    //性别
    @Column(name = "sex")
    private String sex;
    //密码
    @Column(name = "password")
    private String password;

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", num=" + num +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String num, String name, String phone, String sex, String password) {

        this.num = num;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.password = password;
    }
}
