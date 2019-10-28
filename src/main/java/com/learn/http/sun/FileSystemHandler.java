package com.learn.http.sun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

import static com.learn.http.sun.FileSystemUtils.calcRespType;
import static com.sun.org.apache.xml.internal.serialize.Method.HTML;
import static java.util.Arrays.asList;

public class FileSystemHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try {
            String requestURI = exchange.getRequestURI().toString().replace("%20", " ");
            File file = new File("" + requestURI);
            byte[] data;
            String contentType;
            if (file.isDirectory()){
                data = renderFolder(file);
                contentType = HTML;
            } else {
                data = renderFolder(file);
                contentType = calcRespType(file.toString());
            }
            exchange.sendResponseHeaders(200, data.length);
            exchange.getResponseHeaders().put("Content-Type", asList(contentType));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private byte[] renderFolder(File root) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder(8 * 1024);
        result.append("<html><body>");

        File[] files = root.listFiles();
        if (root.getParentFile() != null){
            addFileLine(result, root.getParentFile(), "...");
        }

        Arrays.sort(files, (file0, file1) -> ((file0.isDirectory() ? 0 : 1) - (file1.isDirectory() ? 0 : 1)));

        for (File file : files) {
            addFileLine(result, file, file.getName());
        }

        result.append("</body></html>");
        return result.toString().getBytes("cp1251");
    }

    private void addFileLine(StringBuilder result, File file, String caption) {
        result.append("\n");

        if (caption.equals("...")) {
            // NOP
        } else if (file.isDirectory()){
            result.append("<br><img src=\"/home/vitalik/Pictures/rabstol_net_300_10.jpg\"/>&nbsp;");
        } else {
            result.append("<br><img src=\"/home/vitalik/Pictures/adolf.jpeg\"/>&nbsp;");
        }
        result.append("<a href=\"");
        File absoluteFile = file.getAbsoluteFile();
        result.append("/fs/" + absoluteFile.toString().substring(3));
        result.append("\">");
        result.append(caption);
        result.append("</a>");
    }

    public static byte[] renderPage(File file) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream(64 * 1024);
        Files.copy(Paths.get(file.toURI()), buff);
        return buff.toByteArray();
    }

    public static byte[] renderPage0(File file) throws IOException {
        StringBuilder result = new StringBuilder(8192);
        result.append("<html><body>");

        ByteArrayOutputStream buff = new ByteArrayOutputStream(64 * 1024);
        Files.copy(Paths.get(file.toURI()), buff);
        String str = buff.toString();
        if (file.toString().endsWith(".java")){
            str = str.replace("\n", "<br>").replace(" ", "&nbsp;");
        }
        result.append(str);

        result.append("</body></html>");
        return result.toString().getBytes("cp1251");

    }
}
