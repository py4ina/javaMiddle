package com.learn.http.sun;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.OutputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.asList;

public class ImageHandler implements HttpHandler {
    public static final String FOLDER = "folder.jpeg";
    public static final String FILE= "filer.jpeg";

    public static final String IMG_TEXT= "/home/vitalik/Pictures/rabstol_net_300_10.jpg";
    public static final String IMG_FOLDER= "/home/vitalik/Pictures/adolf.jpeg";

    @Override
    public void handle(HttpExchange exchange) {
        try {
            String requestURI = exchange.getRequestURI().toString();
            System.out.println("requestURI: " + requestURI);

            String fileName = IMG_TEXT;
            if (requestURI.endsWith(FOLDER)){
                fileName = IMG_FOLDER;
            }

            exchange.sendResponseHeaders(200, new File(fileName).length());
            exchange.getResponseHeaders().put("Content-Type", asList("image/png"));

            OutputStream outputStream = exchange.getResponseBody();
            Files.copy(Paths.get(new URI(fileName)), outputStream);
            outputStream.flush();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            exchange.close();
        }

    }
}
