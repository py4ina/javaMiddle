package com.learn.http.blocking_connectionclose;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BlockingHttpServer_multi {
    public static void main(String[] args) throws IOException {
        ExecutorService executor =
                new ThreadPoolExecutor(0, 100,
                        60L,
                        TimeUnit.SECONDS,
                        new SynchronousQueue<>());
        ServerSocket serverSocket = new ServerSocket(8080, 256);

        while (true){
            Socket socket = serverSocket.accept();
//            executor.submit(new BlockingHttpHandler(socket));
        }
    }
}
