#!/bin/bash

echo "Compiling the project..."
javac -d target/classes src/main/java/com/example/exchange/*.java
if [ $? -ne 0 ]; then
    echo "Compilation failed."
    exit 1
fi
echo "Compilation successful."
