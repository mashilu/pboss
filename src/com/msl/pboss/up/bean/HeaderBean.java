package com.msl.pboss.up.bean;

/**
 * Created by mashilu on 2016/7/18.
 */
public class HeaderBean {

        public String Address = "ns1:Address";    // 1 String V30
        public String Username = "ns1:Username";  // 1 String V30
        public String Password = "ns1:Password";  // 1 String V30
        public String BIPCode = "ns1:BIPCode";    // 1 String 8
        public String BIPVer = "ns1:BIPVer";      // 1 String 4
        public String ActivityCode = "ns1:ActivityCode";  // 1 String 8
        public String ProcID = "ns1:ProcID";              // 1 String V30
        public String TransIDO = "ns1:TransIDO";          // 1 String V30
        public String TransIDH = "ns1:TransIDH";          // ? String V30
        public String ProcessTime = "ns1:ProcessTime";    // 1 String 14
        public String TestFlag = "ns1:TestFlag";          // 1 String 1
        public String SvcConVer = "ns1:SvcConVer";        // 1 String 4

        public String getAddress() {
                return Address;
        }

        public void setAddress(String address) {
                Address = address;
        }

        public String getUsername() {
                return Username;
        }

        public void setUsername(String username) {
                Username = username;
        }

        public String getPassword() {
                return Password;
        }

        public void setPassword(String password) {
                Password = password;
        }

        public String getBIPCode() {
                return BIPCode;
        }

        public void setBIPCode(String BIPCode) {
                this.BIPCode = BIPCode;
        }

        public String getBIPVer() {
                return BIPVer;
        }

        public void setBIPVer(String BIPVer) {
                this.BIPVer = BIPVer;
        }

        public String getActivityCode() {
                return ActivityCode;
        }

        public void setActivityCode(String activityCode) {
                ActivityCode = activityCode;
        }

        public String getProcID() {
                return ProcID;
        }

        public void setProcID(String procID) {
                ProcID = procID;
        }

        public String getTransIDO() {
                return TransIDO;
        }

        public void setTransIDO(String transIDO) {
                TransIDO = transIDO;
        }

        public String getTransIDH() {
                return TransIDH;
        }

        public void setTransIDH(String transIDH) {
                TransIDH = transIDH;
        }

        public String getProcessTime() {
                return ProcessTime;
        }

        public void setProcessTime(String processTime) {
                ProcessTime = processTime;
        }

        public String getTestFlag() {
                return TestFlag;
        }

        public void setTestFlag(String testFlag) {
                TestFlag = testFlag;
        }

        public String getSvcConVer() {
                return SvcConVer;
        }

        public void setSvcConVer(String svcConVer) {
                SvcConVer = svcConVer;
        }
}
