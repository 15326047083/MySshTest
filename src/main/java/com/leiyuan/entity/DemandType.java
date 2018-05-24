package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 需求分类表
 */
@Entity
@Table(name = "demandtype")
public class DemandType {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //分类名
    @Column(name = "name")
    private String name;
    //分类简介
    @Column(name = "info")
    private String info;
    //建立时间
    @Column(name = "buildTime")
    private String buildTime;
    //需求数量
    @Column(name = "demandNum")
    private int demandNum;

    public DemandType() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(String buildTime) {
        this.buildTime = buildTime;
    }

    public int getDemandNum() {
        return demandNum;
    }

    public void setDemandNum(int demandNum) {
        this.demandNum = demandNum;
    }

    public DemandType(String name, String info, String buildTime, int demandNum) {

        this.name = name;
        this.info = info;
        this.buildTime = buildTime;
        this.demandNum = demandNum;
    }
}
