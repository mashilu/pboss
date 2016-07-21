package com.msl.pboss.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mashilu on 2016/7/12.
 */
public class GetXmlValue {
    public static String getValueByTag(String tagName, String xmlString)
    {
        String[] arr = getElementsByTag(tagName, xmlString);

        if ((arr == null) || (arr.length == 0)) {
            return "";
        }
        return getElementText(arr[0]);
    }

    public static String[] getElementsByTag(String tagName, String xmlString)
    {
        Pattern p = Pattern.compile("<" + tagName + ">([^<]+)</" + tagName + ">");
        Matcher m = p.matcher(xmlString);
        ArrayList al = new ArrayList();
        while (m.find()) {
            al.add(m.group());
        }
        String[] arr = (String[])al.toArray(new String[al.size()]);
        al.clear();
        return arr;
    }

    public static String getElementText(String elementString)
    {
        Pattern p = Pattern.compile(">([^<>]*)<");
        Matcher m = p.matcher(elementString);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }
}
