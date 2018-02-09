/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandro.lcd;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Toshiba
 */
public class Numero {
    
    List<Integer> displayList;

    public List<Integer> getDisplayList() {
        return displayList;
    }

    public void setDisplayList(List<Integer> displayList) {
        this.displayList = displayList;
    }
    
    Numero(Integer ... numeros) {
        this.displayList = Arrays.asList(numeros);
    }   
    
}
