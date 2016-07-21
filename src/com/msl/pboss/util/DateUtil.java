package com.msl.pboss.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mashilu on 2016/7/18.
 */
public class DateUtil {

    private String getCurrDate()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(date);
    }
    private String getCurrDateSSS()
    {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(date);
    }
}
