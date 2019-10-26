package com.learn.http.blocking_connectionclose;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingHttpServer_single {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081, 256);
        while (true){
            Socket socket = serverSocket.accept();
            new BlockingHttpHandler(socket).call();
        }
    }
}
