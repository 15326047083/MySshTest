package com.leiyuan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 需求表
 */
@Entity
@Table(name = "damand")
public class Damand {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    //发布需求的用户id
    @Column(name = "userId")
    private String userId;
    //用户联系方式：微信
    @Column(name = "weixin")
    private String weixin;
    //用户联系方式：qq
    @Column(name = "qq")
    private String qq;
    //需求详情
    @Column(name = "info")
    private String info;
    //赏金
    @Column(name = "bounty")
    private String bounty;
    //开始时间
    @Column(name = "startTime")
    private String startTime;
    //最晚结束时间
    @Column(name = "endTime")
    private String endTime;
    //需求状态0：正常状态1：有人接单了2：订单完成3：订单取消4：订单过期
    @Column(name = "flag")
    private int flag;

    public Damand() {

    }

    public Damand(String userId, String weixin, String qq, String info, String bounty, String startTime, String endTime, int flag) {
        this.userId = userId;
        this.weixin = weixin;
        this.qq = qq;
        this.info = info;
        this.bounty = bounty;
        this.startTime = startTime;
        this.endTime = endTime;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Damand{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", info='" + info + '\'' +
                ", bounty='" + bounty + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
