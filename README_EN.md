
# Minimal Service Exchange Framework

## Overview

This project demonstrates how to build minimal, high-performance, and lightweight services in Java without relying on external frameworks or dependency managers. The entire implementation uses only native Java capabilities to create a simple service exchange framework.

## Use Case: Simple Messaging Application

### Context

In a world dominated by heavy frameworks and complex dependency management systems, simplicity and performance are often overlooked. This project showcases the core principles of creating lightweight and efficient Java services, ideal for embedded systems or resource-constrained environments.

### Workflow

1. **Server Initialization**
   - The server listens for incoming connections on port `8080`.
   - Each client connection is handled on a separate thread for scalability.

2. **Client Interaction**
   - The client sends a request message to the server.
   - The server processes the request and responds.

3. **Communication Contract**
   - The `ExchangeObject` interface defines the format for data exchange.
   - Concrete classes, such as `CustomMessage`, implement this interface to ensure consistent communication.

### Demonstration

#### Input (Client Request):
```json
{
    "type": "request",
    "content": "Hello, Server!"
}
```

#### Server Log:
```
Received: Hello, Server!
```

#### Output (Server Response):
```json
{
    "type": "response",
    "content": "Hello, Client!"
}
```

## Key Features

1. **Minimal Dependencies**
   - No frameworks like Spring or dependency managers like Maven/Gradle.
   - Entirely built using the Java Development Kit (JDK).

2. **High Performance**
   - Low-overhead socket communication.
   - Efficient serialization and deserialization using native Java.

3. **Simplicity**
   - Easy-to-read and maintainable code.
   - Clear separation of concerns: server logic, client logic, and communication protocol.

4. **Scalability**
   - The server handles multiple clients concurrently using threads.
   - Designed to be easily extended for larger use cases.

## How to Run

### Prerequisites
- Java Development Kit (JDK) installed.

### Steps

1. **Compile the Project**
   ```bash
   ./compile.sh
   ```

2. **Run the Server**
   ```bash
   java -cp target/classes com.example.exchange.ServerMain
   ```

3. **Run the Client**
   ```bash
   java -cp target/classes com.example.exchange.ClientMain
   ```

4. **Observe the Logs**
   - The server logs each request it processes.
   - The client logs the server's response.

### Automated Script

Alternatively, use the provided script to automate the compilation, server startup, client execution, and server shutdown.

```bash
./run_server_client.sh
```

## Future Extensions

1. **Asynchronous Communication**: Replace threading with non-blocking I/O for better scalability.
2. **Security**: Add encryption for secure message exchange.
3. **Custom Protocols**: Replace serialized objects with lightweight protocols like JSON or Protocol Buffers.

## Benefits

- Lightweight and perfect for IoT or microservices.
- Educational for learning core Java concepts such as sockets, serialization, and threading.
- Fully customizable to fit various use cases.

---

This minimalistic project proves that powerful services can be built without unnecessary complexity, making it an excellent showcase for foundational software design.
