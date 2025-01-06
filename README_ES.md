
# Framework Minimalista de Intercambio de Servicios

## Resumen

Este proyecto demuestra cómo construir servicios ligeros, de alto rendimiento y mínimos en Java sin depender de frameworks externos o gestores de dependencias. Toda la implementación utiliza únicamente capacidades nativas de Java para crear un framework sencillo de intercambio de servicios.

## Caso de Uso: Aplicación Simple de Mensajería

### Contexto

En un mundo dominado por frameworks pesados y sistemas de gestión de dependencias complejos, a menudo se pasa por alto la simplicidad y el rendimiento. Este proyecto muestra los principios básicos de creación de servicios Java ligeros y eficientes, ideal para sistemas embebidos o entornos con recursos limitados.

### Flujo de Trabajo

1. **Inicialización del Servidor**
   - El servidor escucha conexiones entrantes en el puerto `8080`.
   - Cada conexión del cliente se maneja en un hilo separado para escalabilidad.

2. **Interacción del Cliente**
   - El cliente envía un mensaje de solicitud al servidor.
   - El servidor procesa la solicitud y responde.

3. **Contrato de Comunicación**
   - La interfaz `ExchangeObject` define el formato para el intercambio de datos.
   - Clases concretas, como `CustomMessage`, implementan esta interfaz para garantizar una comunicación coherente.

### Demostración

#### Entrada (Solicitud del Cliente):
```json
{
    "type": "request",
    "content": "¡Hola, Servidor!"
}
```

#### Log del Servidor:
```
Recibido: ¡Hola, Servidor!
```

#### Salida (Respuesta del Servidor):
```json
{
    "type": "response",
    "content": "¡Hola, Cliente!"
}
```

## Características Clave

1. **Dependencias Mínimas**
   - Sin frameworks como Spring ni gestores de dependencias como Maven/Gradle.
   - Construido enteramente usando el Java Development Kit (JDK).

2. **Alto Rendimiento**
   - Comunicación por sockets de bajo costo.
   - Serialización y deserialización eficientes utilizando Java nativo.

3. **Simplicidad**
   - Código fácil de leer y mantener.
   - Separación clara de responsabilidades: lógica del servidor, lógica del cliente y protocolo de comunicación.

4. **Escalabilidad**
   - El servidor maneja múltiples clientes simultáneamente usando hilos.
   - Diseñado para extenderse fácilmente a casos de uso más grandes.

## Cómo Ejecutar

### Requisitos Previos
- Java Development Kit (JDK) instalado.

### Pasos

1. **Compilar el Proyecto**
   ```bash
   ./compile.sh
   ```

2. **Ejecutar el Servidor**
   ```bash
   java -cp target/classes com.example.exchange.ServerMain
   ```

3. **Ejecutar el Cliente**
   ```bash
   java -cp target/classes com.example.exchange.ClientMain
   ```

4. **Observar los Logs**
   - El servidor registra cada solicitud que procesa.
   - El cliente muestra la respuesta del servidor.

### Script Automatizado

Alternativamente, use el script proporcionado para automatizar la compilación, inicio del servidor, ejecución del cliente y cierre del servidor.

```bash
./run_server_client.sh
```

## Extensiones Futuras

1. **Comunicación Asíncrona**: Reemplace los hilos con E/S no bloqueante para mejor escalabilidad.
2. **Seguridad**: Agregar encriptación para un intercambio seguro de mensajes.
3. **Protocolos Personalizados**: Sustituir objetos serializados con protocolos ligeros como JSON o Protocol Buffers.

## Beneficios

- Ligero y perfecto para IoT o microservicios.
- Educativo para aprender conceptos básicos de Java como sockets, serialización y hilos.
- Totalmente personalizable para adaptarse a diversos casos de uso.

---

Este proyecto minimalista demuestra que se pueden construir servicios potentes sin complejidad innecesaria, convirtiéndolo en un excelente ejemplo de diseño de software fundamental.
