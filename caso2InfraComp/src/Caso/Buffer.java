package Caso;
import java.util.ArrayList;


public class Buffer {

    public int marcoPaginas;
    public ArrayList<ArrayList<Integer>> tablaMarcoPaginas;
    public int falloPagina;

    public ArrayList<Integer> tabla;

    public Buffer(int marcoPaginas) {
        this.marcoPaginas = marcoPaginas;
        this.tablaMarcoPaginas = new ArrayList<>();
        this.falloPagina = 0;
        this.tabla = new ArrayList<>();

        ingresoValores();
    }

    public void ingresoValores() {
        for (int i = 0; i < marcoPaginas; i++) {
            ArrayList<Integer> marco = new ArrayList<>();
            marco.add(0);
            marco.add(-1);
            tablaMarcoPaginas.add(marco);
        }
    }

    public synchronized void añadirPagina(int numeroPagina) {

        insertarPagina(numeroPagina);

        synchronized (this){
            notify();
        }
    }

    public synchronized void años(){

        while(check_put()== false){
            try{
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        envejecer();
        synchronized (this){
            notify();
        } 
    }

    public void envejecer(){
        for (int i = 0; i < marcoPaginas; i++) {
            if(tablaMarcoPaginas.get(i).get(0) != -1){
                int numero = tablaMarcoPaginas.get(i).get(1);
                numero += 1;
                tablaMarcoPaginas.get(i).set(1, numero);
            }
        }
    }

    public ArrayList<Integer> traduccionOriginalFlat(ArrayList<Info> original){

        ArrayList<Integer> traduccion = new ArrayList<>();

        for (int i = 0; i < original.size(); i++) {
            traduccion.add(original.get(i).getnumero());
        }

        return traduccion;
     }

     public boolean compa_edad(int pagina){
        
        if (tablaMarcoPaginas.size() == marcoPaginas && tabla.contains(pagina) == false) {
            return true;
        }
            return false;
     }

     public boolean check_put(){
        for(int i = 0; i < marcoPaginas; i++){
            if(tablaMarcoPaginas.get(i).get(0) != -1){
                return true;
            }
        }
        return false;
     }

    public void insertarPagina(int numeroPagina){
        boolean monitor = true;
        int num = 0;

        if(tabla.size()<marcoPaginas || tabla.contains(numeroPagina) == true){

            while(monitor == true && num < tablaMarcoPaginas.size()){

                if(tablaMarcoPaginas.get(num).get(0) == -1){
                    tablaMarcoPaginas.get(num).set(0, numeroPagina);
                    tablaMarcoPaginas.get(num).set(1, 0);
                    tabla.add(numeroPagina);
                    monitor = false;
                }

                else if (tablaMarcoPaginas.get(num).get(0) == numeroPagina){
                    tablaMarcoPaginas.get(num).set(1, 0);
                    monitor = false;
                }

                num +=1;
            }

            num = 0;
            monitor = true;
        }

        else{
            errorPagina(numeroPagina);
        }
    }

    public void errorPagina(int numeroPagina){
        int num = 0;
        int indicado = 0;

        for(int i= 0; i < tablaMarcoPaginas.size(); i++){
            if(tablaMarcoPaginas.get(i).get(1) > num){
                num = tablaMarcoPaginas.get(i).get(1);
                indicado = tablaMarcoPaginas.get(i).get(0);
            }
        }

        for(int j = 0; j < tabla.size(); j++){
            if(tabla.get(j) == indicado){
                tabla.remove(j);
            }
        }

        for(int k = 0; k < tablaMarcoPaginas.size(); k++){
            if(tablaMarcoPaginas.get(k).get(0) == indicado){
                tablaMarcoPaginas.get(k).set(0, numeroPagina);
                tablaMarcoPaginas.get(k).set(1, 0);
                tabla.add(numeroPagina);
            }
        }

        falloPagina += 1;
    }

    
}
