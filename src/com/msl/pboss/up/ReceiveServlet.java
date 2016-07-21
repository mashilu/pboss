package com.msl.pboss.up;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


/**
 * Created by mashilu on 2016/7/12.
 */
@WebServlet(name = "demo", urlPatterns = "/demo")
public class ReceiveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int size = req.getContentLength();
        System.out.printf("=============content size is %d\n", size);

        InputStream is = req.getInputStream();
        byte[] reqBodyBytes = readBytes(is, size);

        String res = new String(reqBodyBytes, "UTF-8");

        System.out.println("===========content string is" + res);

        System.out.println("===========begin to parse.........");


    }

    public static final byte[] readBytes(InputStream is, int contentLen) {
        if ( contentLen > 0 ) {
            int readLen = 0;
            int readLengthThisTime = 0;
            byte[] message = new byte[contentLen];
            try {
                while (readLen < contentLen) {
                    readLengthThisTime = is.read(message, readLen, contentLen - readLen);
                    if (readLengthThisTime == -1) {
                        break;
                    }
                    readLen += readLengthThisTime;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return message;
        }
        return new byte[]{};
    }
}
