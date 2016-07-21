package com.msl.pboss.up.parser;

import com.msl.pboss.up.bean.UserStatusChgReqBean;
import com.msl.pboss.up.constant.PbossConstant;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashilu on 2016/7/18.
 */
public class UserStatusChgReqParser extends AbstractSoapParser {

    public UserStatusChgReqBean parseBody(Element root)  {
        UserStatusChgReqBean userStatusChgReqBean = null;
        Element bodyEle = root.element(PbossConstant.BODY);
        if (bodyEle == null) {
            System.out.println("error---------- [body] is null!");
            return null;
        }
        Element userStatusChgReqEle = bodyEle.element(PbossConstant.USERSTATUSCHGREQ);
        if (userStatusChgReqEle != null) {
            userStatusChgReqBean = new UserStatusChgReqBean();
            parseUserStatusInfo(userStatusChgReqEle, userStatusChgReqBean);
        }
        return null;
    }

    private void parseUserStatusInfo(Element userStatusChgReqEle, UserStatusChgReqBean userStatusChgReqBean) {
        List userStatusInfoEleList = userStatusChgReqEle.elements(PbossConstant.USERSTATUSINFO);
        if (userStatusInfoEleList == null || userStatusInfoEleList.isEmpty()) {
            System.out.println("error----------: [userStatusInfo] is null!");
        }

        List<UserStatusChgReqBean.UserStatusInfo> userStatusInfoList =
                new ArrayList<UserStatusChgReqBean.UserStatusInfo>();
        UserStatusChgReqBean.UserStatusInfo userStatusInfo = null;

        for (Element userStatusInfoEle : userStatusInfoEleList) {
            if (!checkUserStatusInfo(userStatusInfoEle)) {
                System.out.println("error----------: one UserStatusInfo element is wrong");
                break;
            }
            userStatusInfo = new UserStatusChgReqBean.UserStatusInfo();
            userStatusInfo.setOprSeq(userStatusInfoEle.elementTextTrim(PbossConstant.OPRSEQ));
            userStatusInfo.setOprTime(userStatusInfoEle.elementTextTrim(PbossConstant.OPRTIME));
            userStatusInfo.setSubsID(userStatusInfoEle.elementTextTrim(PbossConstant.SUBSID));
            userStatusInfo.setMobNum(userStatusInfoEle.elementTextTrim(PbossConstant.MOBNUM));
            userStatusInfo.setUserStatus(userStatusInfoEle.elementTextTrim(PbossConstant.USERSTATUS));
            userStatusInfo.setStatusOprTime(userStatusInfoEle.elementTextTrim(PbossConstant.STATUSOPRTIME));
            userStatusInfo.setProvinceID(userStatusInfoEle.elementTextTrim(PbossConstant.PROVINCDID));
        }

    }

    private boolean checkUserStatusInfo(Element userStatusInfoEle) {
        List elementList;
        Element element;

        // OprSeq 1 String F32
        elementList = userStatusInfoEle.elements(PbossConstant.OPRSEQ);
        if (elementList.size() != 1) {
            System.out.println("error----------: [userStatusInfo.OprSeq]: count is not 1");
            return false;
        }
        element = (Element)elementList.get(0);
        if (element.getText().length() != PbossConstant.OPRSEQ_LEN_F) {
            System.out.println("error----------: [userStatusInfo.OprSeq]:  length is not " + PbossConstant.OPRSEQ_LEN_F);
            return false;
        } else if (checkOprSeq(element.getText())) {
            System.out.println("error----------: [userStatusInfo.OprSeq]: format is wrong!");
            return false;
        }

        // OprTime 1 String F14 YYYYMMDDHH24MISS
        elementList = userStatusInfoEle.elements(PbossConstant.OPRTIME);
        if (elementList.size() != 1) {
            System.out.println("error----------: [userStatusInfo.OprTime]: count is not 1");
            return false;
        }
        element = (Element)elementList.get(0);
        if (element.getText().length() != PbossConstant.OPRTIME_LEN_F) {
            System.out.println("error----------: [userStatusInfo.OprTime]:  length is not " + PbossConstant.OPRTIME_LEN_F);
            return false;
        } else if (checkOprTime(element.getText())) {
            System.out.println("error----------: [userStatusInfo.OprTime]: format is wrong!");
            return false;
        }

        // SubsID 1 String F18
        elementList = userStatusInfoEle.elements(PbossConstant.SUBSID);
        if (elementList.size() != 1) {
            System.out.println("error----------: [userStatusInfo.SubsID]: count is not 1");
            return false;
        }
        element = (Element)elementList.get(0);
        if (element.getText().length() != PbossConstant.SUBSID_LEN_F) {
            System.out.println("error----------: [userStatusInfo.SubsID]:  length is not " + PbossConstant.OPRTIME_LEN_F);
            return false;
        } else if (checkSubsID(element.getText())) {
            System.out.println("error----------: [userStatusInfo.SubsID]: format is wrong!");
            return false;
        }

        // MobNum 1 String V20
        elementList = userStatusInfoEle.elements(PbossConstant.MOBNUM);
        if (elementList.size() != 1) {
            System.out.println("error----------: [userStatusInfo.MobNum]: count is not 1");
            return false;
        }
        element = (Element)elementList.get(0);
        int mobNumlen = element.getText().length();
        if (mobNumlen <= 0 || mobNumlen > PbossConstant.MOBNUM_LEN_V) {
            System.out.println("error----------: [userStatusInfo.MobNum]:  length is not between in 0 and " + PbossConstant.MOBNUM_LEN_V);
            return false;
        } else if (checkMobNum(element.getText())) {
            System.out.println("error----------: [userStatusInfo.MobNum]: format is wrong!");
            return false;
        }

        return true;
    }

    private boolean checkOprSeq(String text) {
        // TODO: check the format of OprSeq
        return true;
    }

    private boolean checkOprTime(String text) {
        // TODO: check the format of OprTime
        return true;
    }

    private boolean checkSubsID(String text) {
        // TODO: check the format of SubsID
        return true;
    }
    private boolean checkMobNum(String text) {
        // TODO: check the format of MobNum
        return true;
    }
    private boolean checkUserStatus(String text) {
        // TODO: check the format of UserStatus
        return true;
    }
    private boolean checkStatusOprTime(String text) {
        // TODO: check the format of StatusOprTime
        return true;
    }
    private boolean checkProvincdID(String text) {
        // TODO: check the format of ProvincdID
        return true;
    }
}
