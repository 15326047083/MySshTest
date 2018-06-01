package com.leiyuan.vo;


public class DemandUser {
    private String demandId;
    private String typeId;
    private String setUserId;
    private String typeName;
    private String setUserNum;
    private String setUserName;
    private String setUserSex;
    private int setUserStar;
    private String weixin;
    private String qq;
    private String info;
    private String place;
    private String bounty;
    private String startTime;
    private String endTime;
    private int flag;

    public DemandUser() {

    }

    public DemandUser(String demandId, String typeId, String setUserId, String typeName, String setUserNum, String
            setUserName, String
                              setUserSex, int setUserStar, String weixin, String qq, String info, String place,
                      String bounty, String
                              startTime, String endTime, int flag) {
        this.demandId = demandId;
        this.typeId = typeId;
        this.setUserId = setUserId;
        this.typeName = typeName;
        this.setUserNum = setUserNum;
        this.setUserName = setUserName;
        this.setUserSex = setUserSex;
        this.setUserStar = setUserStar;
        this.weixin = weixin;
        this.qq = qq;
        this.info = info;
        this.place = place;
        this.bounty = bounty;
        this.startTime = startTime;
        this.endTime = endTime;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DemandUser{" +
                "demandId='" + demandId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", setUserId='" + setUserId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", setUserNum='" + setUserNum + '\'' +
                ", setUserName='" + setUserName + '\'' +
                ", setUserSex='" + setUserSex + '\'' +
                ", setUserStar=" + setUserStar +
                ", weixin='" + weixin + '\'' +
                ", qq='" + qq + '\'' +
                ", info='" + info + '\'' +
                ", place='" + place + '\'' +
                ", bounty='" + bounty + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", flag=" + flag +
                '}';
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getSetUserId() {
        return setUserId;
    }

    public void setSetUserId(String setUserId) {
        this.setUserId = setUserId;
    }

    public String getSetUserNum() {
        return setUserNum;
    }

    public void setSetUserNum(String setUserNum) {
        this.setUserNum = setUserNum;
    }

    public String getSetUserName() {
        return setUserName;
    }

    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    public String getSetUserSex() {
        return setUserSex;
    }

    public void setSetUserSex(String setUserSex) {
        this.setUserSex = setUserSex;
    }

    public int getSetUserStar() {
        return setUserStar;
    }

    public void setSetUserStar(int setUserStar) {
        this.setUserStar = setUserStar;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
