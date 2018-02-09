/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejandro.lcd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class impresion {
     public static void main(String[] args) {
         List<String> listaComando = new ArrayList<>();
         int espacioDig;
         
         try (Scanner espacio = new Scanner(System.in)) {
                
                System.out.print("Digite el espacio entre los digitos (valor entre 0 y 5): ");
             String valor = espacio.next();
             //int numero = Integer.parseInt(valor);
             
             if (LCD.esEntero(valor)) 
                {
                    espacioDig = Integer.parseInt(valor);
                    
                    // se valida que el espaciado este entre 0 y 5
                    if(espacioDig <0 || espacioDig >5)
                    {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                    
                } 
                else 
                {
                    throw new IllegalArgumentException("Cadena " + valor
                            + " no es un entero");
                }
             do
                {
                    System.out.print("Entrada: ");
                    valor = espacio.next();
                    if(!valor.equalsIgnoreCase("0,0"))
                    {
                        listaComando.add(valor);
                    }
                }while (!valor.equalsIgnoreCase("0,0")); 
            
         

        LCD lcd = new LCD();
        lcd.calcularMatrizDisplay(2);//size
        for(int i = 0; i<10; i++){
        lcd.pintarMatriz(lcd.arrayNumeros[i]);
            System.out.println(" ");
        }
        
        }
         LCD lCD = new LCD();

            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    lCD.procesar(iterator.next(), espacioDig);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }
         catch (Exception ex){
                    System.out.println("Error: "+ex.getMessage());
                }
    }
}
