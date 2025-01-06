package com.example.exchange;

import java.io.*;
import java.net.Socket;

public class Client {
    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public ExchangeObject send(ExchangeObject request) {
        try (Socket socket = new Socket(host, port);
             ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {
            output.writeObject(request);
            return (ExchangeObject) input.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
