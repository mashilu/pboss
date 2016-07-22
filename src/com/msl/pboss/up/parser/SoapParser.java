package com.msl.pboss.up.parser;

import com.msl.pboss.up.bean.HeaderBean;
import com.msl.pboss.up.constant.PbossConstant;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mashilu on 2016/7/18.
 */
public class SoapParser {

    private Map<String, String> parserMap;

    public SoapParser() {
        parserMap = new HashMap<>();
        parserMap.put(PbossConstant.BIPCODE_USERSTATUSCHGREQ, "com.msl.pboss.up.parser.UserStatusChgReqParser");
    }

    public HeaderBean parseMsg(String xml) {
        Document doc;
        Element root = null;
        try {
            doc = DocumentHelper.parseText(xml);
            root = doc.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        HeaderBean headerBean = parseHeaderMsg(root);
        if (headerBean == null) {
            System.out.println("error----------: header is null");
            return null;
        }
        String reqBipcode = headerBean.getBIPCode();
        System.out.println("[parseMsg]==========request bipcode is " + reqBipcode);
        if (!parserMap.containsKey(reqBipcode)) {
            System.out.println("error----------: bip code is not right");
        }
        HeaderBean bodyBean = null;
        try {
            String parserName = parserMap.get(headerBean.getBIPCode());
            AbstractSoapParser soapParser = (AbstractSoapParser)(Class.forName(parserName).newInstance());
            if (soapParser != null) {
                bodyBean = soapParser.parseBody(root);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        copyHeaderInfo2Body(headerBean, bodyBean);

        return bodyBean;
    }

    private void copyHeaderInfo2Body(HeaderBean headerBean, HeaderBean bodyBean) {
        if (headerBean != null && bodyBean != null) {
            bodyBean.setAddress(headerBean.getAddress());
            bodyBean.setUsername(headerBean.getUsername());
            bodyBean.setPassword(headerBean.getPassword());
            bodyBean.setBIPCode(headerBean.getBIPCode());
            bodyBean.setBIPVer(headerBean.getBIPVer());
            bodyBean.setActivityCode(headerBean.getActivityCode());
            bodyBean.setProcID(headerBean.getProcID());
            bodyBean.setTransIDO(headerBean.getTransIDO());
            bodyBean.setTransIDH(headerBean.getTransIDH());
            bodyBean.setProcessTime(headerBean.getProcessTime());
            bodyBean.setTestFlag(headerBean.getTestFlag());
            bodyBean.setSvcConVer(headerBean.getSvcConVer());
        }
    }

    public HeaderBean parseHeaderMsg(Element root) {

        Element headerEle = root.element(PbossConstant.HEADER);
        HeaderBean headerBean = null;

        if (headerEle != null) {
            headerBean = new HeaderBean();
            headerBean.setAddress(headerEle.elementTextTrim(PbossConstant.HEADER_ADDRESS));
            headerBean.setUsername(headerEle.elementTextTrim(PbossConstant.HEADER_USERNAME));
            headerBean.setPassword(headerEle.elementTextTrim(PbossConstant.HEADER_PASSWORD));
            headerBean.setBIPCode(headerEle.elementTextTrim(PbossConstant.HEADER_BIPCODE));
            headerBean.setBIPVer(headerEle.elementTextTrim(PbossConstant.HEADER_BIPVER));
            headerBean.setActivityCode(headerEle.elementTextTrim(PbossConstant.HEADER_ACTIVITYCODE));
            headerBean.setProcID(headerEle.elementTextTrim(PbossConstant.HEADER_PROCID));
            headerBean.setTransIDO(headerEle.elementTextTrim(PbossConstant.HEADER_TRANSIDO));
            headerBean.setTransIDH(headerEle.elementTextTrim(PbossConstant.HEADER_TRANSIDH));
            headerBean.setProcessTime(headerEle.elementTextTrim(PbossConstant.HEADER_PROCESSTIME));
            headerBean.setTestFlag(headerEle.elementTextTrim(PbossConstant.HEADER_TESTFLAG));
            headerBean.setSvcConVer(headerEle.elementTextTrim(PbossConstant.HEADER_SVCCONVER));
        }

        return headerBean;
    }
}
