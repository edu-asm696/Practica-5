package Interfaces;

// Interfaz genérica 
public interface ArreglosInterface<T> {
    
    /**
     * Revierte el orden de los elementos en un arreglo.
     * @param arreglo El arreglo a revertir.
     * @return El mismo arreglo con los elementos en orden inverso.
     */

    T[] revertir(T[] arreglo);

    // Aquí se podrían añadir otros métodos de manejo de arreglos
    // (ej. ordenar, buscar, etc.)
}