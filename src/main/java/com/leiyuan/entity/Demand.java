package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 需求表
 */
@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //发布需求的用户id
    @Column(name = "setUserId")
    private String setUserId;
    //接单服务商的用户id
    @Column(name = "getUserId")
    private String getUserId;
    //订单类型id
    @Column(name = "typeId")
    private String typeId;
    //用户联系方式：微信
    @Column(name = "weixin")
    private String weixin;
    //用户联系方式：qq
    @Column(name = "qq")
    private String qq;
    //需求详情
    @Column(name = "info")
    private String info;
    //需求地址
    @Column(name = "place")
    private String place;
    //赏金
    @Column(name = "bounty")
    private String bounty;
    //开始时间
    @Column(name = "startTime")
    private String startTime;
    //最晚结束时间
    @Column(name = "endTime")
    private String endTime;
    @Column(name = "endLongTime")
    private long endLongTime;
    //需求状态0：正常状态1：有人接单了2：订单完成3：订单取消4：订单过期
    @Column(name = "flag")
    private int flag;

    public Demand() {

    }

    public Demand(String setUserId, String getUserId, String typeId, String weixin, String qq, String info, String
            place, String bounty, String startTime, String endTime, long endLongTime, int flag) {
        this.setUserId = setUserId;
        this.getUserId = getUserId;
        this.typeId = typeId;
        this.weixin = weixin;
        this.qq = qq;
        this.info = info;
        this.place = place;
        this.bounty = bounty;
        this.startTime = startTime;
        this.endTime = endTime;
        this.endLongTime = endLongTime;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id='" + id + '\'' +
                ", setUserId='" + setUserId + '\'' +
                ", getUserId='" + getUserId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", info='" + info + '\'' +
                ", place='" + place + '\'' +
                ", bounty='" + bounty + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", endLongTime=" + endLongTime +
                ", flag=" + flag +
                '}';
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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getBounty() {
        return bounty;
    }

    public void setBounty(String bounty) {
        this.bounty = bounty;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getEndLongTime() {
        return endLongTime;
    }

    public void setEndLongTime(long endLongTime) {
        this.endLongTime = endLongTime;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
