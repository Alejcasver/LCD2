/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandro.lcd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toshiba
 */
public class LCD {

    static Numero[] arrayNumeros = new Numero[10];

    static {
        arrayNumeros[0] = new Numero(1, 2, 3, 4, 5, 7);
        arrayNumeros[1] = new Numero(3, 4);
        arrayNumeros[2] = new Numero(2, 3, 5, 6, 7);
        arrayNumeros[3] = new Numero(3, 4, 5, 6, 7);
        arrayNumeros[4] = new Numero(1, 3, 4, 6);
        arrayNumeros[5] = new Numero(1, 4, 5, 6, 7);
        arrayNumeros[6] = new Numero(1, 2, 4, 5, 6, 7);
        arrayNumeros[7] = new Numero(3, 4, 5);
        arrayNumeros[8] = new Numero(1, 2, 3, 4, 5, 6, 7);
        arrayNumeros[9] = new Numero(1, 3, 4, 5, 6, 7);
    }

    static String[][] inicializarMatriz(int size) {
        int x = size * 2 + 3;
        int y = size + 2;
        String[][] display = new String[x][y];
        limpiarMatriz(display);

        return display;
    }

    static void limpiarMatriz(String[][] display) {
        for (String[] display1 : display) {
            for (int j = 0; j < display1.length; j++) {
                display1[j] = " ";
            }
        }
    }

    static String[][] getMatriz(Numero numero, int size) {
        String[][] display = inicializarMatriz(size);
        for (Integer displaySegment : numero.getDisplayList()) {
            switch (displaySegment) {
                case 1:
                    for (int i = 1; i < size + 1; i++) {
                        display[i][0] = "|";
                    }
                    break;
                case 2:
                    int x = size + 2;
                    for (int i = x; i < size * 2 + 2; i++) {
                        display[i][0] = "|";
                    }
                    break;
                case 3:
                    int y = size + 1;
                    for (int i = 1; i < size + 1; i++) {
                        display[i][y] = "|";
                    }

                    break;
                case 4:
                    y = size + 1;
                    x = size + 2;
                    for (int i = x; i < size * 2 + 2; i++) {
                        display[i][y] = "|";
                    }
                    break;
                case 5:
                    for (int j = 1; j < size + 1; j++) {
                        display[0][j] = "-";
                    }
                    break;
                case 6:
                    x = size + 1;
                    for (int j = 1; j < size + 1; j++) {
                        display[x][j] = "-";
                    }
                    break;
                case 7:
                    x = size * 2 + 2;
                    for (int j = 1; j < size + 1; j++) {
                        display[x][j] = "-";
                    }
                    break;

            }
        }

        return display;
    }

    public static void procesarMatriz(int espacio, int size, List<Integer> listNumeros) {
        String espacios = "";
        for (int k = 0; k < espacio; k++) {
            espacios = espacios + " ";
        }        
        List<String[][]> listDisplay = new ArrayList<>();
        for (Integer numero : listNumeros) {
            String[][] display = getMatriz(arrayNumeros[numero], size);
            listDisplay.add(display);
        }
        int numeroLineas = size * 2 + 3;
        for (int i = 0; i < numeroLineas; i++) {
            for (String[][] display : listDisplay) {
                for (int j = 0; j < size + 2; j++) {
                    System.out.print(display[i][j]);
                }
                System.out.print(espacios);
            }
            System.out.println();
        }
    }

}
