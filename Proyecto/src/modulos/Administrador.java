package modulos;

// Clase Administrador que hereda de Usuario 
public class Administrador extends Usuario {

    // Constructor por parámetros
    public Administrador(String nombre, String correo) {
        // Invoca al constructor padre (Usuario) y asigna el Rol "Administrador"
        super(nombre, correo, "Administrador");
    }

    // Método abstracto 
    @Override
    public void mostrarMenu() {
        System.out.println("Menú del Administrador"); // 
        System.out.println("1. Registrar un nuevo Usuario"); // 
        System.out.println("2. Eliminar un usuario"); // 
        System.out.println("3. Ver Lista de Usuarios"); // 
        System.out.println("4. Ver Lista de Tareas"); // 
        System.out.println("5. Crear nueva Tarea"); // 
        System.out.println("6. Salir");
    }
}