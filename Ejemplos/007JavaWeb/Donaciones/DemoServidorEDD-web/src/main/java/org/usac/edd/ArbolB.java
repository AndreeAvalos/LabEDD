package org.usac.edd;

import java.util.ArrayList;

/**
 *
 * @author esvux
 */
public class ArbolB {

    public static ArbolB getInstance() {
        if(instancia == null)
            instancia = new ArbolB();
        return instancia;
    }
    
    private static ArbolB instancia = null;
    
    private ArbolB() {
        nodos = new ArrayList<>();
        nombre = "";
        password = "";
    }
    
    private ArrayList<Donacion> nodos;
    private String nombre;
    private String password;

    public void agregarDonacion(Donacion nueva) {
        nodos.add(nueva);        
    }
    
    public ArrayList<Donacion> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Donacion> nodos) {
        this.nodos = nodos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
