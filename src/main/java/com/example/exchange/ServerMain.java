package com.example.exchange;

public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server(8080, request -> {
            System.out.println("Received: " + ((CustomMessage) request).getContent());
            return new CustomMessage("response", "Hello, Client!");
        });
        server.start();
    }
}
