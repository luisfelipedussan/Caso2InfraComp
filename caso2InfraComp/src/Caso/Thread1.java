package Caso;

import java.util.ArrayList;

public class Thread1 extends Thread {

    public Buffer buffer;
    public ArrayList<Info> tabla;
    public boolean estado;

    public Thread1(Buffer buffer, ArrayList<Info> tabla) {
        this.buffer = buffer;
        this.tabla = tabla;
        this.estado = true;
    }

    @Override

    public void run() {

        for (int i = 0; i<tabla.size(); i++){
            Info actual = tabla.get(i);
            int referenciaPagina = actual.getnumero();

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

    public ArrayList<Info> getTabla() {
        return tabla;
    }

    public boolean getEstado(){
        return estado;
    }
    
}
