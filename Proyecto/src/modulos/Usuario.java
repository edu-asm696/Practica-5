package modulos;

// Clase abstracta 
public abstract class Usuario {
    
    // Atributos protegidos 
    protected String Nombre;
    protected String Correo;
    protected String Rol;

    // Constructor por omisión 
    public Usuario() {
    }

    // Constructor con parámetros 
    public Usuario(String nombre, String correo, String rol) {
        
        // Validación de Nombre 
        // Nota: Se omite la regla ">= 5 caracteres" por nombres como "Ana" y "Juan"
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe estar vacío.");
        }
        
        // Validación de Correo 
        if (correo == null || !correo.contains("@") || !correo.endsWith(".com")) {
            throw new IllegalArgumentException("El formato del correo es inválido. Debe contener '@' y terminar en '.com'.");
        }

        this.Nombre = nombre;
        this.Correo = correo;
        this.Rol = rol;
    }

    // --- Getters ---
    public String getNombre() {
        return Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getRol() {
        return Rol;
    }

    // Método para formato CSV 
    public String toCSV() {
        return this.Nombre + ", " + this.Correo + ", " + this.Rol;
    }

    // --- Métodos de usado en la Práctica 4 ---

    @Override
    public String toString() { // 
        return "Usuario [Nombre=" + Nombre + ", Correo=" + Correo + ", Rol=" + Rol + "]";
    }

    // Método abstracto 
    public abstract void mostrarMenu();
}