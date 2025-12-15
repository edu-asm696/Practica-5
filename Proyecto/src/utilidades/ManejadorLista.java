package utilidades;

import Interfaces.ArreglosInterface;
import java.util.Arrays;
import java.util.Collections;

// Clase genérica que implementa la interfaz genérica 
public class ManejadorLista<T> implements ArreglosInterface<T> {

    /**
     * Revierte el orden de un arreglo genérico en el lugar.
     * @param arreglo El arreglo de tipo T a revertir.
     * @return El mismo arreglo, pero revertido.
     */

    @Override
    public T[] revertir(T[] arreglo) {
        // Usamos la utilidad Collections.reverse
        // Se aplica sobre la vista de lista del arreglo (Arrays.asList)
        // Esto modifica el arreglo original 
        Collections.reverse(Arrays.asList(arreglo));
        return arreglo;
    }
}