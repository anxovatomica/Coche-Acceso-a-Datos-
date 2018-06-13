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
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author linusdufol
 */
public class CocheRecuperacionAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File renault = null;
        File archivo2 = null;
        File email = null;
        FileReader fr = null;
        ArrayList<String> ids = new ArrayList<>();
        ArrayList<String> pak = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //path archivos Marcel
            String pathM1 = "/Users/linusdufol/Documents/workspace/CocheRecuperacionAD/src/cocherecuperacionad/renault.txt";
            String pathM2 = "/Users/linusdufol/Documents/workspace/CocheRecuperacionAD/src/cocherecuperacionad/seat.txt";
            //Path archivos Renzo
            String pathR1 = "PON AQUI TU PATH DEL ARCHIVO RENAULT.TXT";
            String pathR2 = "PON AQUI TU PATH DEL ARCHIVO sEAT.TXT";
            
            renault = new File(pathM1);
            
            if (!renault.exists()) {
                System.out.println("el archivo no existe");
            }
            
            String linea;
            fr = new FileReader(renault);
            br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                ids.add(linea);
            }
            
            String paquete = "";
            String paquete2 = "";

            //System.out.print("EL VECTOR ES : \n ");//MOSTRAR LOS DATOS DEL ARREGLO
            for (int j = 0; j < ids.size(); j++) {
                paquete = ids.get(j);
                linea = paquete.substring(0, 6);
                if (linea.equals(args[0])) {
                    System.out.print(paquete + "\n");
                    paquete2 = paquete;
                }
            }

            String[] pakage = paquete2.split(";");

            String[] pakagesec = pakage[1].split(",");
            if (pakagesec.length == 0) {
                System.out.println("el ID no existe");
            }
            
            //obtenemos el primer renault*****************************
            archivo2 = new File("C:\\archivo1.txt");
            if (!archivo2.exists()) {
                System.out.println("el archivo no existe");
            }
            fr = new FileReader(archivo2);//aqui lo leemos y lo pasamos a FileReader
            br = new BufferedReader(fr);
            String linea2;
            while ((linea2 = br.readLine()) != null) {
                pak.add(linea2);
            }
            //obtenemos el segundo renault ***************************
            for (int c = 0; c < pakagesec.length; c++) {

                String[] pakage2 = null;
                for (int j = 0; j < pak.size(); j++) {
                    pakage2 = pak.get(j).split(";");
                    if (pakage2[0].equals(pakagesec[c])) {
                        linea2 = pak.get(j);
                    }
                }
                if (linea == null) {
                    System.out.println("el paquete no existe");
                }
                pakage2 = linea2.split(";");
//************************************** escritura*******************************
                /*FileWriter fw = new FileWriter("emailMainteiner" + c + " .txt");

                String strs[] = {"From: correo@gmail.com", "To: " + pakage2[2], "Dear: " + pakage2[1], "You have a new bug: ", pakage2[0] + " RC bug number #" + pakage[0], "Please, fix it as soon as possible.", "Cheers."};
                fw.flush();
                for (int i = 0; i < strs.length; i++) {
                    fw.write(strs[i] + "\n");
                }
                fw.close();*/
            }

        }//FIN DEL TRY//FIN DEL TRY//FIN DEL TRY//FIN DEL TRY
        catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
    
}
