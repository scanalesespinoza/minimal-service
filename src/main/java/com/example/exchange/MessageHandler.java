package com.example.exchange;

@FunctionalInterface
public interface MessageHandler {
    ExchangeObject handle(ExchangeObject request);
}
