package com.msl.pboss.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * Created by mashilu on 2016/7/18.
 */
public class Test {
    public static void main(String args[]) {
        String xml = "<test></test>";
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootEle = doc.getRootElement();
            List<Element> elementList = rootEle.elements("a");
            System.out.println(elementList.size());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
