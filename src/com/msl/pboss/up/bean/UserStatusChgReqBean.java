package com.msl.pboss.up.bean;

import java.util.List;

/**
 * Created by mashilu on 2016/7/18.
 */
public class UserStatusChgReqBean extends HeaderBean {

    private List<UserStatusInfo> userStatusInfoList;

    public List<UserStatusInfo> getUserStatusInfoList() {
        return userStatusInfoList;
    }

    public void setUserStatusInfoList(List<UserStatusInfo> userStatusInfoList) {
        this.userStatusInfoList = userStatusInfoList;
    }

    // 内部类
    public static class UserStatusInfo {

        private String OprSeq;
        private String OprTime;
        private String SubsID;
        private String MobNum;
        private String UserStatus;
        private String StatusOprTime;
        private String ProvinceID;

        public String getOprSeq() {
            return OprSeq;
        }

        public void setOprSeq(String oprSeq) {
            OprSeq = oprSeq;
        }

        public String getOprTime() {
            return OprTime;
        }

        public void setOprTime(String oprTime) {
            OprTime = oprTime;
        }

        public String getSubsID() {
            return SubsID;
        }

        public void setSubsID(String subsID) {
            SubsID = subsID;
        }

        public String getMobNum() {
            return MobNum;
        }

        public void setMobNum(String mobNum) {
            MobNum = mobNum;
        }

        public String getUserStatus() {
            return UserStatus;
        }

        public void setUserStatus(String userStatus) {
            UserStatus = userStatus;
        }

        public String getStatusOprTime() {
            return StatusOprTime;
        }

        public void setStatusOprTime(String statusOprTime) {
            StatusOprTime = statusOprTime;
        }

        public String getProvinceID() {
            return ProvinceID;
        }

        public void setProvinceID(String provinceID) {
            ProvinceID = provinceID;
        }
    }

}
