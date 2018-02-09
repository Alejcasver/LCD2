/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandro.lcd;

import static com.alejandro.lcd.ImpresorLCD.isNumeric;

/**
 *
 * @author Toshiba
 */
public class LCD {
    
    Numero[] arrayNumeros = new Numero[10];
    
    
    String[][] display;
    
    private int size;
    
    public LCD() {
        crearNumeros();
    }
    
    void crearNumeros() {
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
    
    void calcularMatrizDisplay(int size) {
        this.size = size;
        int x = size * 2 + 3;
        int y = size + 2;        
        display = new String[x][y];  
        limpiarMatriz();
    }
    
    void limpiarMatriz (){
        for (String[] display1 : display) {
            for (int j = 0; j < display1.length; j++) {
                display1[j] = " ";
            }
        }
    }
    
    void pintarMatriz(Numero numero) {
        limpiarMatriz();
        for(Integer displaySegment: numero.getDisplayList()) {
            switch (displaySegment) {
                case 1:
                    for(int i = 1; i< size+1; i++) {
                        display[i][0] = "|";
                    }                    
                    break;
                case 2:
                    int x = size+2;
                    for(int i = x; i < size * 2+2; i++) {
                        display[i][0] = "|";
                    }                    
                    break;
                case 3:
                    int y = size + 1;
                    for(int i = 1; i< size+1; i++) {
                        display[i][y] = "|";
                    } 
                    
                    break;
                case 4:
                    y = size + 1;
                    x = size + 2;
                    for(int i = x; i < size * 2+2; i++) {
                        display[i][y] = "|";
                    } 
                    break;
                case 5:
                    for(int j = 1; j< size+1; j++) {
                        display[0][j] = "-";
                    }
                    break;
                case 6:
                    x = size+1;
                    for(int j = 1; j< size+1; j++) {
                        display[x][j] = "-";
                    }
                    break;
                case 7:
                    x = size * 2 +2;
                    for(int j = 1; j< size+1; j++) {
                        display[x][j] = "-";
                    }
                    break;                   

            }
        }
        for (int i = 0; i < display.length; i++) {
            for (int j = 0; j < display[i].length; j++) {
                System.out.print(display[i][j]);
            }
            System.out.println();
        }
    }
    static boolean esEntero(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
  /*public static void main(String[] args) {
        LCD lcd = new LCD();
        lcd.calcularMatrizDisplay(4);//size
        for(int i = 0; i<10; i++){
        lcd.pintarMatriz(lcd.arrayNumeros[i]);
            System.out.println(" ");
        }
    }*/
    public void procesar(String comando, int espacioDig) {

        String[] parametros;

        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        //Se hace el split de la cadena
        parametros = comando.split(",");

        //Valida la cantidad de parametros
        if (parametros.length > 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,");
        }

        //Valida la cantidad de parametros
        if (parametros.length < 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }

        //Valida que el parametro size sea un numerico
        if (isNumeric(parametros[0])) {
            tam = Integer.parseInt(parametros[0]);

            // se valida que el size este entre 1 y 10
            if (tam < 1 || tam > 10) {
                throw new IllegalArgumentException("El parametro size [" + tam
                        + "] debe estar entre 1 y 10");
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }

        // Realiza la impresion del numero
        imprimirNumero(tam, parametros[1], espacioDig);

    }
}
