package com.example.exchange;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private final MessageHandler handler;

    public Server(int port, MessageHandler handler) {
        this.port = port;
        this.handler = handler;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(() -> handleClient(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try (ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
             ObjectOutputStream output = new ObjectOutputStream(clientSocket.getOutputStream())) {
            ExchangeObject request = (ExchangeObject) input.readObject();
            ExchangeObject response = handler.handle(request);
            output.writeObject(response);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
