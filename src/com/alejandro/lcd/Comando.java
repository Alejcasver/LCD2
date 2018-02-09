package com.alejandro.lcd;

import java.util.List;

/**
 *
 * @author Alejandro Castillo
 */
public class Comando {
    
    private final int espacio;
    
    private final int size;
    
    private final List<Integer> listNumeros;
    
    public Comando(int espacio, int size, List<Integer> listNumeros) {
        this.size = size;
        this.espacio = espacio;
        this.listNumeros = listNumeros;        
    }

    public int getEspacio() {
        return espacio;
    }

    public int getSize() {
        return size;
    }

    public List<Integer> getListNumeros() {
        return listNumeros;
    }
    
}
