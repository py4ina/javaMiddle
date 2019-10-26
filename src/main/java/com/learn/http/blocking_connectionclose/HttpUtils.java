package com.learn.http.blocking_connectionclose;

import java.io.IOException;
import java.io.InputStream;

public class HttpUtils {
    public static String readRequest(InputStream inputStream) throws IOException {
        String httpHeader = "";
        while (!httpHeader.endsWith("\r\n\r\n")) {
            httpHeader += (char) inputStream.read();
        }
        return httpHeader;
    }
    
    public static String wrapConnectionClose(String text){
        return doWrap(text, "Close");
    }

    public static String wrapConnectionKeepAlive(String text){
        return doWrap(text, "Keep-Alive");
    }

    private static String doWrap(String text, String connectionState) {
        String page = "<html><body>"
                + text
                + "<img src='img_0.jpg/>'"
                + "<img src='img_1.jpg/>'"
                + "<img src='img_2.jpg/>'"
                + "<img src='img_3.jpg/>'"
                + "<img src='img_4.jpg/>'"
//                + "<img src='img_5.jpg/>'"
//                + "<img src='img_6.jpg/>'"
//                + "<img src='img_7.jpg/>'"
//                + "<img src='img_8.jpg/>'"
//                + "<img src='img_9.jpg/>'"
                + "</body></html>";
        return "HTTP/1.1 200 OK\r\n" +
                "Connection:" + connectionState + "\r\n" +
                "Content-Type: text/html: charset=UTF-8\r\n" +
                "Content-Length: " + page.length() + "\r\n" +
                "\r\n" +
                page;
    }
}
