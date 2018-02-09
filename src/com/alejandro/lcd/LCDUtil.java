package com.alejandro.lcd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Castillo
 */
public class LCDUtil {

    public static int obtenerEspacio(String comando) {
        int espacio;
        if (isNumeric(comando)) {
            espacio = Integer.parseInt(comando);

            // se valida que el espaciado este entre 0 y 5
            if (espacio < 0 || espacio > 5) {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }

        } else {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no es un entero");
        }

        return espacio;
    }

    public static Comando obtenerComando(String comando, int espacio) {
        List<Integer> listNumeros = new ArrayList<>();
        String[] parametros;

        int size;
        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }

        //Se hace el split de la cadena
        parametros = comando.split(",");

        //Valida la cantidad de parametros
        if (parametros.length > 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas de un caracter ,");
        }

        //Valida la cantidad de parametros
        if (parametros.length < 2) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos");
        }

        //Valida que el parametro size sea un numerico
        if (isNumeric(parametros[0])) {
            size = Integer.parseInt(parametros[0]);

            // se valida que el size este entre 1 y 10
            if (size < 1 || size > 10) {
                throw new IllegalArgumentException("El parametro size [" + size
                        + "] debe estar entre 1 y 10");
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }
        if (!isNumeric(parametros[1])) {
            throw new IllegalArgumentException("Cadena " + parametros[1]
                    + " no es un entero 2");
        }

        String numeros = parametros[1];
        char[] digitos = numeros.toCharArray();
        for (char digito : digitos) {
            int numero = Integer.parseInt(String.valueOf(digito));
            listNumeros.add(numero);
        }
        return new Comando(espacio, size, listNumeros);
    }

    static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
