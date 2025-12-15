package modulos;

// Clase Empleado que hereda de Usuario 
public class Empleado extends Usuario {

    // Constructor por parámetros
    public Empleado(String nombre, String correo) {
        // Invoca al constructor padre (Usuario) 
        // y asigna el Rol "Empleado"
        super(nombre, correo, "Empleado");
    }

    // Método abstracto 
    @Override
    public void mostrarMenu() {
        System.out.println("Menú del Empleado"); // 
        System.out.println("1. Ver lista de tareas");
        System.out.println("2. Finalizar una tarea"); // 
        System.out.println("6. Salir");
    }
}