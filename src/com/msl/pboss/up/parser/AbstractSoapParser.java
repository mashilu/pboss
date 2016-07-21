package com.msl.pboss.up.parser;

import com.msl.pboss.up.bean.HeaderBean;
import org.dom4j.Element;

/**
 * Created by mashilu on 2016/7/18.
 */
public abstract class AbstractSoapParser {

    protected abstract HeaderBean parseBody(Element bodyEle);
}
