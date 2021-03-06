package com.learn.http.habr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)){
            System.out.println("Server started!");
            System.out.println(serverSocket.getLocalPort());

            while (true){
                // ожидаем подключения
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // для подключившегося клиента открываем потоки
                // чтения и записи

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))){
                    PrintWriter output = new PrintWriter(socket.getOutputStream());

                    // ждем первой строки запроса
                    while (!input.ready());

                    // считываем и печатаем все что было отправлено клиентом
                    System.out.println("----------------------");
                    while (input.ready()){
                        System.out.println(input.readLine());
                    }

                    // отправляем ответ
                    output.println("HTTP/1.1 200 OK");
                    output.println ("header1: value1");
                    output.println ("header2: value2");
                    output.println ("header3: value3");

                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    output.println("<p style='color:red'>Привет всем!</p>");
                    output.flush();

                    // по окончанию выполнения блока try-with-resources потоки,
                    // а вместе с ними и соединение будут закрыты
                    System.out.println("Client disconnected!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
