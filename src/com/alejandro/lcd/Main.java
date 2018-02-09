package com.alejandro.lcd;

/**
 *
 * @author Alejandro Castillo
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {

        // Establece los segmentos de cada numero
        List<Comando> listaComando = new ArrayList<>();
        String comando;
        int espacio;
        List<Integer> listNumeros = new ArrayList<>();

        try {

            try (Scanner lector = new Scanner(System.in)) {

                System.out.print("Espacio entre Digitos (0 a 5): ");
                comando = lector.next();

                // Valida si es un numero y rango
                espacio = LCDUtil.obtenerEspacio(comando);

                do {
                    System.out.print("Entrada: ");
                    comando = lector.next();
                    if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                        listaComando.add(LCDUtil.obtenerComando(comando, espacio));
                    }
                } while (!comando.equalsIgnoreCase(CADENA_FINAL));

                for (Comando comando1 : listaComando) {
                    LCD.procesarMatriz(comando1.getEspacio(), comando1.getSize(), comando1.getListNumeros());
                    System.out.println("");
                }

            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

}
