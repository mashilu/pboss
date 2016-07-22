package com.msl.pboss.up.constant;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by mashilu on 2016/7/18.
 */
public class PbossConstant {

    public static final String BODY = "Body";
    public static final String HEADER = "Header";
    public static final String HEADER_ADDRESS = "Address";
    public static final String HEADER_USERNAME = "Username";
    public static final String HEADER_PASSWORD = "Password";
    public static final String HEADER_BIPCODE = "BIPCode";
    public static final String HEADER_BIPVER = "BIPVer";
    public static final String HEADER_ACTIVITYCODE = "ActivityCode";
    public static final String HEADER_PROCID = "ProcID";
    public static final String HEADER_TRANSIDO = "TransIDO";
    public static final String HEADER_TRANSIDH = "TransIDH";
    public static final String HEADER_PROCESSTIME = "ProcessTime";
    public static final String HEADER_TESTFLAG = "TestFlag";
    public static final String HEADER_SVCCONVER = "SvcConVer";

    // BIPCODE
    public static final String BIPCODE_USERSTATUSCHGREQ = "BTP2N001";

    // ACTIVITYCODE

    // 报文元素名称
    public static final String USERSTATUSCHGREQ = "UserStatusChgReq";
    public static final String USERSTATUSINFO = "UserStatusInfo";
    public static final String OPRSEQ = "OprSeq";
    public static final String OPRTIME = "OprTime";
    public static final String SUBSID = "SubsID";
    public static final String MOBNUM = "MobNum";
    public static final String USERSTATUS = "UserStatus";
    public static final String STATUSOPRTIME = "StatusOprTime";
    public static final String PROVINCDID = "ProvincdID";

    // 报文字段长度 F 定长  V 变长
    public static final int OPRSEQ_LEN_F = 32;
    public static final int OPRTIME_LEN_F = 14;
    public static final int SUBSID_LEN_F = 18;
    public static final int MOBNUM_LEN_V = 20;
    public static final int USERSTATUS_LEN_F = 2;
    public static final int STATUSOPRTIME_LEN_F = 14;
    public static final int PROVINCDID_LEN_F = 3;
}
