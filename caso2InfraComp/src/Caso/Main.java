package Caso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
   
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> info = leerArchivo("src/Caso/input.txt");
        
        int marcosPagina = info.get(4);
        Modo1 modo1 = new Modo1(info.get(0), info.get(4), info.get(1),
         info.get(2), info.get(3));
        modo1.sumarMatrices( info.get(1), info.get(2), info.get(3));
        modo1.comportamientoProceso();


        ArrayList<Integer> info2 = leerArchivoSalida("src/Caso/output.txt");
        new Modo2(marcosPagina,info2);

       

    }

    public static ArrayList<Integer> leerArchivo(String filename) throws IOException {

        ArrayList<Integer> info = new ArrayList<>();
        
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

    public static ArrayList<Integer> leerArchivoSalida(String filename) throws IOException {

        ArrayList<Integer> info = new ArrayList<>();
       
        
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