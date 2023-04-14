package Caso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Integer> info = leerArchivo("src/Caso/input.txt");
        

        Modo1 modo1 = new Modo1(info.get(0), info.get(4), info.get(1),
         info.get(2), info.get(3));
        modo1.sumarMatrices( info.get(1), info.get(2), info.get(3));
        modo1.comportamientoProceso();

        /*
         * 
         
        
        Modo1 modo2 = new Modo1(info2.get(0), info2.get(4), info2.get(1),
        info2.get(2), info2.get(3));
        modo2.comportamientoSistema();
        */
        List<Integer> info2 = leerArchivoSalida("src/Caso/output.txt");
        Modo2 modo2 = new Modo2(info.get(0), info.get(2), info.get(3),
        info.get(4),info2);
        modo2.comportamientoSistema();
       

    }

    public static List<Integer> leerArchivo(String filename) throws IOException {

        List<Integer> info = new ArrayList<>();
        
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("TP = ")) {

                info.add(Integer.parseInt(line.substring(5).trim()));
            } else if (line.startsWith("NF = ")) {

                info.add(Integer.parseInt(line.substring(5).trim()));

            } else if (line.startsWith("NC = ")) {
                info.add(Integer.parseInt(line.substring(5).trim()));

            } else if (line.startsWith("TE = ")) {

                info.add(Integer.parseInt(line.substring(5).trim()));

            } else if (line.startsWith("MP = ")) {

                info.add(Integer.parseInt(line.substring(5).trim()));

            }
        }
        reader.close();
        return info;
    }

    public static List<Integer> leerArchivoSalida(String filename) throws IOException {

        List<Integer> info = new ArrayList<>();
       
        
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("TP=")) {

                info.add(Integer.parseInt(line.substring(3).trim()));
            } else if (line.startsWith("NF=")) {

                info.add(Integer.parseInt(line.substring(3).trim()));

            } else if (line.startsWith("NC=")) {
                info.add(Integer.parseInt(line.substring(3).trim()));

            } else if (line.startsWith("NR=")) {

                info.add(Integer.parseInt(line.substring(3).trim()));


            }else {
                String[] referencia = line.split(",");
                int ref = Integer.parseInt(referencia[1]);
                info.add(ref);
            }
        }
        reader.close();
        return info;
    }
    
}