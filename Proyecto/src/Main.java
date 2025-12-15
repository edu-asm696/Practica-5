import modulos.Administrador;
import modulos.Empleado;
import utilidades.ManejadorLista;
import BD.ManejadorArchivos;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        // 1. Entrada por Terminal 
        // Validamos que tengamos 10 nombres
        if (args.length != 10) {
            System.out.println("Error: Se esperan 10 nombres como argumentos de entrada.");
            System.out.println("Ejemplo: java Main \"Juan\" \"Maria\" ... \"Elena\"");
            return;
        }

        System.out.println("ENTRADA RECIBIDA (10 nombres)");
        for(int i = 0; i < args.length; i++) {
            System.out.println((i+1) + ". " + args[i]);
        }

        System.out.println("\nPROCESANDO DATOS ===");

        // --- 2. Procesamiento ---

        // Instanciamos los manejadores
        ManejadorLista<Administrador> manejadorAdmins = new ManejadorLista<>();
        ManejadorLista<Empleado> manejadorEmps = new ManejadorLista<>();
        ManejadorArchivos manejadorArchivos = new ManejadorArchivos();

        // Nombres de los archivos
        String archivoAdmins = "Administradores.txt";
        String archivoEmps = "Empleados.txt";

        // Creamos los arreglos
        Administrador[] administradores = new Administrador[10];
        Empleado[] empleados = new Empleado[10];
        
        // Arreglos para las líneas de texto (CSV)
        String[] adminStrings = new String[10];
        String[] empStrings = new String[10];

        // 2.1 Convertir nombres a arreglos de Empleados y Administradores 
        try {
            for (int i = 0; i < 10; i++) {
                String nombre = args[i];
                // Usamos el mismo correo para todos (basado en el nombre) 
                String correo = nombre.toLowerCase().split(" ")[0] + "@empresa.com"; 
                
                administradores[i] = new Administrador(nombre, correo);
                empleados[i] = new Empleado(nombre, correo);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear usuario: " + e.getMessage());
            return; // Termina la ejecución si hay un error
        }
        System.out.println("✔ Usuarios creados automáticamente");
        
        // 2.2 Revertir el orden de ambos arreglos 
        manejadorAdmins.revertir(administradores);
        manejadorEmps.revertir(empleados);
        System.out.println("✔ Listas revertidas correctamente");

        // 2.3 Convertir arreglos de objetos a arreglos de String (formato CSV)
        for(int i=0; i<10; i++){
            adminStrings[i] = administradores[i].toCSV();
            empStrings[i] = empleados[i].toCSV();
        }

        // 2.4 Guardar la lista revertida en archivo (sobrescribir) 
        manejadorArchivos.escribirArregloAArchivo(adminStrings, archivoAdmins);
        manejadorArchivos.escribirArregloAArchivo(empStrings, archivoEmps);
        System.out.println("✔ Archivos '" + archivoAdmins + "' y '" + archivoEmps + "' creados con 10 usuarios.");

        // 2.5 Crear y añadir un nuevo empleado y administrador 
        try {
            // Usamos el ejemplo "Roberto" 
            Administrador nuevoAdmin = new Administrador("Roberto", "roberto@empresa.com");
            Empleado nuevoEmpleado = new Empleado("Roberto", "roberto@empresa.com");

            // Añadir (append) al final del archivo
            manejadorArchivos.escribirLineaAlFinal(nuevoAdmin.toCSV(), archivoAdmins);
            manejadorArchivos.escribirLineaAlFinal(nuevoEmpleado.toCSV(), archivoEmps);
            System.out.println("✔ Nuevos usuarios añadidos a los archivos");
        
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear nuevo usuario: " + e.getMessage());
        }

        // --- 3. Salida Estándar ---

        // 3.1 Leer los archivos completos 
        String[] listaFinalAdmins = manejadorArchivos.leerArchivoComoArreglo(archivoAdmins);
        String[] listaFinalEmps = manejadorArchivos.leerArchivoComoArreglo(archivoEmps);

        // 3.2 Mostrar lista de 11 Administradores 
        System.out.println("\nRESULTADO FINAL (11 administradores) ===");
        if (listaFinalAdmins != null) {
            for (int i = 0; i < listaFinalAdmins.length; i++) {
                // Formateamos la salida para que coincida con el ejemplo 
                String linea = listaFinalAdmins[i].replace(",", " ");
                System.out.println((i + 1) + ". " + linea);
            }
        }

        // 3.3 Mostrar lista de 11 Empleados 
        System.out.println("\nRESULTADO FINAL (11 empleados) ===");
        if (listaFinalEmps != null) {
            for (int i = 0; i < listaFinalEmps.length; i++) {
                // Formateamos la salida para que coincida con el ejemplo 
                String linea = listaFinalEmps[i].replace(",", " ");
                System.out.println((i + 1) + ". " + linea.replace(" - ", " "));
            }
        }
    }
}