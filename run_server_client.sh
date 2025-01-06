#!/bin/bash

echo "Starting the automation script for Server and Client"

echo "Compiling the project..."
javac -d target/classes src/main/java/com/example/exchange/*.java
if [ $? -ne 0 ]; then
    echo "Compilation failed. Exiting."
    exit 1
fi

echo "Starting the server..."
java -cp target/classes com.example.exchange.ServerMain &
SERVER_PID=$!
echo "Server started with PID: $SERVER_PID"

echo "Waiting for the server to initialize..."
sleep 5

echo "Starting the client..."
java -cp target/classes com.example.exchange.ClientMain
echo "Client execution finished."

echo "Waiting for 5 seconds before shutting down the server..."
sleep 5

echo "Shutting down the server..."
kill $SERVER_PID
echo "Server shutdown complete."

echo "Automation script completed. Exiting."
