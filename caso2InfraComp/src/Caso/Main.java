package Caso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Integer> param = leerArchivo("src/Caso/input.txt");


        Modo1 modo1 = new Modo1(param.get(0), param.get(4), param.get(1), param.get(2), param.get(3));
        modo1.sumarMatrices( param.get(1), param.get(2), param.get(3));
        modo1.comportamientoProceso();
    }

    public static List<Integer> leerArchivo(String filename) throws IOException {
        List<Integer> param = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith("TP = ")) {
                param.add(Integer.parseInt(line.substring(5).trim()));
            } else if (line.startsWith("NF = ")) {
                param.add(Integer.parseInt(line.substring(5).trim()));
            } else if (line.startsWith("NC = ")) {
                param.add(Integer.parseInt(line.substring(5).trim()));
            } else if (line.startsWith("TE = ")) {
                param.add(Integer.parseInt(line.substring(5).trim()));
            } else if (line.startsWith("MP = ")) {
                param.add(Integer.parseInt(line.substring(5).trim()));
            }
        }
        reader.close();
        return param;
    }
    
}