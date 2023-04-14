package Caso;

public class Info {
   
    public int numero;

    public int desplazamiento;

    public int numerPagina;

    public int posicion;

    public Info(int numero, int desplazamiento, int numerPagina, int posicion) {
        this.numero = numero;
        this.desplazamiento = desplazamiento;
        this.numerPagina = numerPagina;
        this.posicion = posicion;
    }

    public int getnumero() {
        return numero;
    }

    public int getdesplazamiento() {
        return desplazamiento;
    }

    public int getPageNumber() {
        return numerPagina;
    }

    public int getposicion() {
        return posicion;
    }
}
