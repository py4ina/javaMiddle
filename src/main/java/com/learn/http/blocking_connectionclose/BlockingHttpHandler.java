package com.learn.http.blocking_connectionclose;


import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;


public class BlockingHttpHandler {
    private final Socket socket;

    public BlockingHttpHandler(Socket socket) {
        this.socket = socket;
    }

    public void  call() throws IOException {
        //read
        String httpRequest = HttpUtils.readRequest(socket.getInputStream());
        System.out.println("---------------------");
        System.out.println(httpRequest);

        //process
        String httpResponse = HttpUtils.wrapConnectionClose("Hello!");
        System.out.println(httpResponse);

        //write
        Writer writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        writer.write(httpResponse);
        writer.flush();
    }
}
