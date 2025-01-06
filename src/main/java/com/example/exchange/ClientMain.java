package com.example.exchange;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client("localhost", 8080);
        ExchangeObject response = client.send(new CustomMessage("request", "Hello, Server!"));
        if (response instanceof CustomMessage) {
            System.out.println("Server replied: " + ((CustomMessage) response).getContent());
        }
    }
}
