/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandro.lcd;

import java.util.List;

/**
 *
 * @author Toshiba
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
