package com.learn.http.sun;

public class FileSystemUtils {
    public static final String HTML = "text/html; charset=cp1251";

    public static String calcRespType(String pathName) {
        if (pathName.endsWith(".xml")) {
            return "application/xml";
        } else if (pathName.endsWith(".pdf")) {
            return "application/pdf";
        } else if (pathName.endsWith(".zip")) {
            return "application/zip";
        } else if (pathName.endsWith(".txt")) {
            return "txt/plain";
        }
        return null;
    }
}
