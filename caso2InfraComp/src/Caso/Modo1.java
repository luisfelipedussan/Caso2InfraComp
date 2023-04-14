package Caso;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Modo1 {

    private Integer tamPag; // Tamaño de la página en bytes
    private Integer marcos; // Número de marcos de página disponibles
    private Integer numFilas; // Número de filas de la matriz
    private Integer numCol; // Número de columnas de la matriz
    private Integer tamEl; // Tamaño de los elementos de la matriz
   

    public Modo1(Integer tamPag, Integer marcos, Integer numFilas, Integer numCol, Integer tamEl) {
        this.tamPag = tamPag;
        this.marcos = marcos;
        this.numFilas = numFilas;
        this.numCol = numCol;
        this.tamEl = tamEl;
       
    }

   
    public int[][] sumarMatrices(int n, int m, int numPaginas) {
        //int [][] matrizPaginas = new int[numPaginas][10];
        int[][] matriz1 = new int[n][m];
        int[][] matriz2 = new int[n][m];
        int[][] matrizSuma = new int[n][m];
        Random rand = new Random();

        // Llenar las dos matrices aleatoriamente
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz1[i][j] = rand.nextInt(10); // Números aleatorios entre 0 y 9
                matriz2[i][j] = rand.nextInt(10);
            }
        }

        // Sumar las dos matrices en la matriz de la suma
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrizSuma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matrizSuma;
    }

    

    public void comportamientoProceso() {
        /*
         * Se calcula el tamaño de una pagina completa. 
         */
        int tamPagina= tamPag * tamEl;
        int tamMatriz = numFilas * numCol * tamEl;
        
        /*cuantas paginas ocupa una matriz completa  */
        int pagMatriz = (tamMatriz + tamPagina- 1) / tamPagina;


        // ReferenumColias 
        int tReferenumColias = numFilas * numCol * 3;

        // Crear objeto StringBuilder para almacenar el resultado
        StringBuilder resultado = new StringBuilder();
    
        // Agregar inumFilasormación básica al resultado
        resultado.append("TP=").append(tamPag).append("\n");
        resultado.append("NF=").append(numFilas).append("\n");
        resultado.append("NC=").append(numCol).append("\n");
        resultado.append("NR=").append(tReferenumColias).append("\n");
        
        // Crear listas para almacenar referenumColias de cada matriz
        List<String> lMatrizA = new ArrayList<String>();
        List<String> lMatrizB = new ArrayList<String>();
        List<String> lMatrizC = new ArrayList<String>();
        
        // Iterar sobre cada matriz y cada elemento
        for (int k = 0; k < 3; k++) {
            // Asignar letra a la matriz
            char matriz = (char) ('A' + k);
            // Iterar sobre cada fila de la matriz


            for (int i = 0; i < numFilas; i++) {
                int desplazamientoFila = (i % (tamPag / numCol)) * numCol;
                int pagVirtualFila = i / (tamPag / numCol);
        
                for (int j = 0; j < numCol; j++) {
                   
                    int paginaVirtualColumna = j / (tamPag / numFilas);
                    int desplazamientoColumna = j % (tamPag / numFilas);
                    int paginaVirtual = pagVirtualFila * marcos + 
                    paginaVirtualColumna + k * pagMatriz;
                    int desplazamiento = (desplazamientoFila + desplazamientoColumna) * tamEl;
                    String referenumColia = "[" + matriz + "-" + i + "-" + j + "]," + paginaVirtual 
                    + "," + desplazamiento + "\n";
                    switch(matriz) {
                        case 'A':
                            lMatrizA.add(referenumColia);
                            break;
                        case 'B':
                            lMatrizB.add(referenumColia);
                            break;
                        case 'C':
                            lMatrizC.add(referenumColia);
                            break;
                    }
                }
            }
        }
    
        for (int i = 0; i < lMatrizA.size(); i++) 
        {
            resultado.append(lMatrizA.get(i));
            resultado.append(lMatrizB.get(i));
            resultado.append(lMatrizC.get(i));
        }
        
   
        String nombreArchivo = "output.txt"; 
        String rutaArchivo = "src/Caso/" + nombreArchivo;
        File archivoSalida = new File(rutaArchivo);
        

        try (PrintWriter out = new PrintWriter(new FileWriter(archivoSalida))) {
            out.print(resultado.toString());
        } catch (IOException e) {
            System.err.println("Error al generar el archivo: " + e.getMessage());
        }
    }



    
        
}


