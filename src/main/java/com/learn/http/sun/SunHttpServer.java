package com.learn.http.sun;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import static com.sun.net.httpserver.spi.HttpServerProvider.provider;

public class SunHttpServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = provider().createHttpServer(new InetSocketAddress(8080), 256);
        System.out.println(1);
        server.createContext("/home/", new FileSystemHandler());
        server.createContext("/img/", new ImageHandler());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
    }
}
