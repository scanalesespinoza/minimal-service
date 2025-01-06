package com.example.exchange;

public class CustomMessage implements ExchangeObject {
    private final String type;
    private final String content;

    public CustomMessage(String type, String content) {
        this.type = type;
        this.content = content;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
