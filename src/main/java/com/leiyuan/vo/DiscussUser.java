package com.leiyuan.vo;

import com.leiyuan.entity.Discuss;

public class DiscussUser {
    private String discussId;
    private String setUserId;
    private String setUserName;
    private String setUserNum;
    private int setUserStar;
    private String getUserId;
    private String info;
    private int star;

    public DiscussUser() {

    }

    public DiscussUser(String discussId, String setUserId, String setUserName, String setUserNum, int setUserStar,
                       String getUserId, String info, int star) {
        this.discussId = discussId;
        this.setUserId = setUserId;
        this.setUserName = setUserName;
        this.setUserNum = setUserNum;
        this.setUserStar = setUserStar;
        this.getUserId = getUserId;
        this.info = info;
        this.star = star;
    }

    @Override
    public String toString() {
        return "DiscussUser{" +
                "discussId='" + discussId + '\'' +
                ", setUserId='" + setUserId + '\'' +
                ", setUserName='" + setUserName + '\'' +
                ", setUserNum='" + setUserNum + '\'' +
                ", setUserStar='" + setUserStar + '\'' +
                ", getUserId='" + getUserId + '\'' +
                ", info='" + info + '\'' +
                ", star=" + star +
                '}';
    }

    public String getDiscussId() {
        return discussId;
    }

    public void setDiscussId(String discussId) {
        this.discussId = discussId;
    }

    public String getSetUserId() {
        return setUserId;
    }

    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    public String getSetUserName() {
        return setUserName;
    }

    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    public String getSetUserNum() {
        return setUserNum;
    }

    public void setSetUserNum(String setUserNum) {
        this.setUserNum = setUserNum;
    }

    public int getSetUserStar() {
        return setUserStar;
    }

    public void setSetUserStar(int setUserStar) {
        this.setUserStar = setUserStar;
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
}
