package Caso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Modo2 {

    private Integer tamPag; // Tamaño de la página en bytes
    private Integer marcos; // Número de marcos de página disponibles
    private Integer numFilas; // Número de filas de la matriz
    private Integer numCol; // Número de columnas de la matriz
    private Integer tamEl; // Tamaño de los elementos de la matriz
    private List<Integer> info;
    public Modo1 modo1;
    public Buffer buffer;
    private ArrayList<ArrayList<Integer>> paginas;

    public Modo2(Integer tamPag, Integer numFilas, Integer numCol, Integer numRef, List<Integer> info2) throws InterruptedException {
        this.tamPag = tamPag;
        this.numFilas = numFilas;
        this.numCol = numCol;

        this.info = info2;
        //Buffer buffer = new Buffer(marcos);
       // this.buffer = buffer;
        /**
        ---Hay que insertar la tabla de referencias 
    
        Thread1 thread1 = new Thread1(buffer,modo1.get);
        */
    }
     /**
     * 
     */
    public void comportamientoSistema(){

        System.out.println(info);
    }

    
}
