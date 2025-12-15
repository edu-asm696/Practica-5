package BD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// Clase para manejar operaciones de E/S de archivos 

public class ManejadorArchivos {

// Lee todo el contenido de un archivo y lo retorna como un arreglo de Strings.
  
    public String[] leerArchivoComoArreglo(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();
        // Usamos try-with-resources para el manejo automático de recursos 
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            // Manejo de excepciones 
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null; // Retorna null en caso de error
        }
        // Convierte la lista a un arreglo de String 
        return lineas.toArray(new String[0]);
    }

    /**
     * Busca una cadena específica en un archivo y retorna la primera línea
     * que la contiene. 
     */

    public String buscarLinea(String cadenaBuscada, String nombreArchivo) {
        // Usamos try-with-resources 
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(cadenaBuscada)) {
                    return linea; // Retorna la primera coincidencia 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar en el archivo: " + e.getMessage());
        }
        return null; // Retorna null si no se encuentra 
    }

// Añade una nueva línea al final del archivo. 

    public void escribirLineaAlFinal(String linea, String nombreArchivo) {
        // El 'true' en FileWriter indica modo "append" (añadir al final) 
        // Usamos try-with-resources 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(linea);
            bw.newLine(); // Maneja saltos de línea automáticamente 
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Escribe un arreglo completo al archivo, sobrescribiendo el contenido
     * existente. 
     */

    public void escribirArregloAArchivo(String[] lineas, String nombreArchivo) {
        // El 'false' (o la ausencia de) en FileWriter indica modo "overwrite"
        // 
        // Usamos try-with-resources 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine(); // Cada elemento es una nueva línea 
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el arreglo en el archivo: " + e.getMessage());
        }
    }
}