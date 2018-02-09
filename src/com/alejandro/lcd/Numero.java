package com.alejandro.lcd;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alejandro Castillo
 */
public class Numero {

    List<Integer> displayList;

    public List<Integer> getDisplayList() {
        return displayList;
    }

    Numero(Integer... numeros) {
        this.displayList = Arrays.asList(numeros);
    }

}
