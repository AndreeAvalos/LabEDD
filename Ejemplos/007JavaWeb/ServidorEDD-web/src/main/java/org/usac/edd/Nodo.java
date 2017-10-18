package org.usac.edd;


import java.util.ArrayList;

/**
 *
 * @author esvux
 */
public class Nodo {
    private String nombre;
    private ArrayList<Arista> aristas;

    public Nodo() {
        this("");
    }

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.aristas = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Arista> getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList<Arista> aristas) {
        this.aristas = aristas;
    }
    
}
