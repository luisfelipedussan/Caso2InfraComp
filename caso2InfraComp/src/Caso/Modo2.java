package Caso;

import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Modo2 {

    public Modo1 modo1;
    public int tamañoMarcoPagina;
    public Buffer buffer;
    private ArrayList<ArrayList<Integer>> paginas;

    public Modo2(Modo1 modo1, int tamañoMarcoPagina) throws InterruptedException {
        this.modo1 = modo1;
        this.tamañoMarcoPagina = tamañoMarcoPagina;
        Buffer buffer = new Buffer(tamañoMarcoPagina);
        this.buffer = buffer;
        /**
        ---Hay que insertar la tabla de referencias 
    
        Thread1 thread1 = new Thread1(buffer,modo1.get);
        */
    }


    
}
