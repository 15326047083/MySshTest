package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "discuss")
public class Discess {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "setUserId")
    private String setUserId;
    @Column(name = "getUserId")
    private String getUserId;
    @Column(name = "info")
    private String info;
    @Column(name = "star")
    private int star;
    @Column(name = "date")
    private String date;

    public Discess() {

    }

    public Discess(String id, String setUserId, String getUserId, String info, int star, String date) {
        this.id = id;
        this.setUserId = setUserId;
        this.getUserId = getUserId;
        this.info = info;
        this.star = star;
        this.date = date;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSetUserId() {
        return setUserId;
    }

    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    public String getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(String getUserId) {
        this.getUserId = getUserId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Discess{" +
                "id='" + id + '\'' +
                ", setUserId='" + setUserId + '\'' +
                ", getUserId='" + getUserId + '\'' +
                ", info='" + info + '\'' +
                ", star=" + star +
                ", date='" + date + '\'' +
                '}';
    }
}
