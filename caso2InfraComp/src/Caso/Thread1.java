package Caso;

import java.util.ArrayList;

public class Thread1 extends Thread {

    public Buffer buffer;
    public ArrayList<Integer> tabla;
    public boolean estado;

    public Thread1(Buffer buffer, ArrayList<Integer> info2) {
        this.buffer = buffer;
        this.tabla = info2;
        this.estado = true;
    }

    @Override

    public void run() {

        for (int i = 5; i<tabla.size(); i++){
            Integer referenciaPagina = tabla.get(i);
          

            try {
                actualizarTablaMarcoPagina(referenciaPagina);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        estado = false;
    }

    public void actualizarTablaMarcoPagina(int referenciaPagina ) throws InterruptedException{

        buffer.añadirPagina(referenciaPagina);
        try{
            Thread.sleep(2);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public ArrayList<Integer> getTabla() {
        return tabla;
    }

    public boolean getEstado(){
        return estado;
    }
    
}
