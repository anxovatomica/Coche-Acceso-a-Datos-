/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocherecuperacionad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author linusdufol
 */

public class CocheRecuperacionAD {
private static Coche coche;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File renault = null;
        File archivo2 = null;
        File email = null;
        FileReader fr = null;
        
        ArrayList<String> arrayPalabras = new ArrayList<>();
        
        
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //path archivos Marcel
            String pathM1 = "/Users/linusdufol/Documents/workspace/CocheRecuperacionAD/src/cocherecuperacionad/renault.txt";
            //String pathM2 = "/Users/linusdufol/Documents/workspace/CocheRecuperacionAD/src/cocherecuperacionad/seat.txt";
            //Path archivos Renzo
            //String pathR1 = "PON AQUI TU PATH DEL ARCHIVO RENAULT.TXT";
            //String pathR2 = "PON AQUI TU PATH DEL ARCHIVO sEAT.TXT";
            BufferedReader reader = new BufferedReader(new FileReader(pathM1));
            renault = new File(pathM1);
            
            String linea = null;
            fr = new FileReader(renault);
            br = new BufferedReader(fr);
            int x = 0;
            Coche[] arrayCoches = new Coche[3];
            String[] car = new String[10];
            
            
            while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            // Split line on comma.
            String[] parts = line.split(",");
            for (String part : parts) {
                //System.out.println(part);
                arrayPalabras.add(part);
                
            }
     
        }
        //System.out.println(arrayPalabras.get(5));
        reader.close();
        
        mostrarModelo(arrayPalabras);
        mostrarTodo(arrayPalabras, linea, br, car, arrayCoches, x);
        mostrarPrecio(arrayPalabras);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
    // Método para imprimir el array de Personas
    static void imprimeArrayPersonas(Coche[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println((i+1) + ". " + array[i].getModelo() + " - Altura: " + array[i].getAño() + " - Edad: " + array[i].getKm() + " - Edad: " + array[i].getPrecio());
        }
    }
    static void mostrarPrecio(ArrayList<String> arrayPalabras){
        int max = 0;
        String z = "";
        int x = 0;
        for (int i = 3; i < arrayPalabras.size(); i = i + 4) {
            if (Integer.parseInt(arrayPalabras.get(i)) > max) {
                max = Integer.parseInt(arrayPalabras.get(i));
                z = arrayPalabras.get(x);
                x = x + 4;
            }
        }
        System.out.println("El coche más caro es: " + z + " con el precio " + max);
        /*
        int i = 3;
        while(i < arrayPalabras.size()){
                
            System.out.println("Precio: " + arrayPalabras.get(i));
                i = i + 4;
            }*/
    }
    static void mostrarModelo(ArrayList<String> arrayPalabras){
        int i = 0;
        while(i < arrayPalabras.size()){
                
            System.out.println("Modelo: " + arrayPalabras.get(i));
                i = i + 4;
            }
    }
    static void mostrarTodo(ArrayList<String> arrayPalabras, String linea, BufferedReader br, String[] car, Coche[] arrayPersonas, int x) throws IOException{
         while ((linea = br.readLine()) != null) {
                arrayPalabras.add(linea);
                car = linea.split(",");
                //System.out.println(car[x]);
                coche = new Coche(car[0], Integer.parseInt(car[1]), Integer.parseInt(car[2]), Double.parseDouble(car[3]));
                System.out.println(coche);
                arrayPersonas[x] = new Coche(car[0], Integer.parseInt(car[1]), Integer.parseInt(car[2]), Double.parseDouble(car[3]));
                x++;
            }
    }
}
