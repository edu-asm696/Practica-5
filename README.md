Práctica 5: Genéricos y Persistencia en Archivos
Tareas (Laboratorio 5) | Autor: Eduardo Alejandro Sánchez Moya

Este proyecto es una aplicación de consola en Java que implementa Tipos Genéricos (Generics) para manipular colecciones de objetos de forma segura y reutilizable. Además, integra lectura y escritura de archivos de texto (persistencia de datos) y procesamiento de argumentos de línea de comandos.

Objetivo
Implementar una solución escalable que permita:
1. Recibir datos dinámicos desde la terminal (argumentos `main`).
2. Utilizar clases genéricas (`ManejadorLista<T>`) para manipular arreglos de diferentes tipos (`Empleado` y `Administrador`) sin duplicar código.
3. Persistir la información procesada en archivos de texto plano (`.txt`) simulando una base de datos simple (CSV).

Descripción
El flujo del programa es el siguiente:
1. Entrada: Recibe 10 nombres como argumentos al ejecutar el programa.
2. Procesamiento:
   - Genera objetos `Administrador` y `Empleado` automáticamente con correos generados.
   - Utiliza una clase genérica para **revertir** el orden de los arreglos.
3. Persistencia:
   - Guarda los listados revertidos en `Administradores.txt` y `Empleados.txt`.
   - Añade un nuevo registro ("Roberto") al final de los archivos existentes (modo append).
4. Salida: Lee los archivos generados y muestra el listado final de 11 usuarios en consola.

Justificación Técnica (Por qué usar Genéricos)
Se eligió la implementación con Genéricos (Versión 3) sobre la sobrecarga de métodos o el uso de `Object` por las siguientes razones:
- Seguridad de Tipos (Type Safety): Previene errores en tiempo de ejecución al validar los tipos durante la compilación.
- Escalabilidad: Si se crea un nuevo tipo de usuario (ej. `Invitado`), la lógica de `ManejadorLista<T>` funciona sin modificar el código.
- Código Limpio: Elimina la necesidad de *castings* manuales y reduce la duplicidad de código.

Tecnologías utilizadas
- Java: JDK 
- Generics: Interfaz `ArreglosInterface<T>` y clase `ManejadorLista<T>`.
- Java I/O: `BufferedReader` y `BufferedWriter` para manejo eficiente de archivos.
- Collections: Uso de `Collections.reverse`.

Estructura del Proyecto
- `src/Main.java`: Orquestador del flujo y validación de argumentos de entrada.
- `src/Interfaces/ArreglosInterface.java`: Contrato genérico para operaciones de arreglos.
- `src/utilidades/ManejadorLista.java`: Implementación genérica de la lógica de negocio.
- `src/BD/ManejadorArchivos.java`: Clase encargada de la E/S (Lectura/Escritura) de archivos.
- `src/modulos/*.java`: Modelos de datos (`Usuario`, `Empleado`, `Administrador`).

Instrucciones de ejecución 
Descargar las carpetas: 
Compilar el código desde la carpeta src:
`javac Main.java modulos/*.java utilidades/*.java BD/*.java Interfaces/*.java`
Al ejecutar el programa debes proporcionar exactamente 10 nombres como argumentos.
`java Main Juan Maria Pedro Luis Ana Sofia Carlos Miguel Laura Elena`
