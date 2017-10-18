package org.usac.edd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase que implementa el patron de diseño SINGLETON, para que siempre se
 * acceda al mismo objeto sin importar el "lugar" de donde se realice el acceso.
 * El patron de diseño se compone de:
 * 1) Instancia privada y estatica
 * 2) Metodo publico y estatico para acceder a la unica Instancia
 * 3) Constructor privado, asi se garantiza que se puede acceder
 * al elemento unicamente por medio del metodo estatico getInstance.
 * @author esvux
 */
public class Grafo {

    /**
     * Instancia privada y estatica.
     */
    private static Grafo instance = null;
    
    /**
     * Metodo estatico y publico, unica via de acceso para la Instancia.
     * @return La Instancia de la clase (objeto de tipo Grafo).
     */
    public static Grafo getInstance() {
        synchronized(Grafo.class){
            if(instance==null) {
                instance = new Grafo();
            }
        }
        return instance;
    }
    
    /**
     * Constructor privado, para garantizar que la unica via de acceso sea 
     * el metodo getInstance().
     */
    private Grafo() {
        nodos = new HashMap<>();
    }
    
    // Implementacion de un grafo como una lista de nodos.
    HashMap<String, Nodo> nodos;
    
    public List<Nodo> getNodos() {
        return new ArrayList<>(nodos.values());
    }
    
    public Nodo obtenerNodo(String id) {
        return nodos.get(id);
    }
    
    public boolean agregarNodo(Nodo nuevo) {
        String id = nuevo.getNombre();
        if(nodos.containsKey(id)) {
            return false;
        }
        nodos.put(id, nuevo);
        return true;
    }
    
    public boolean actualizarNodo(String id, Nodo nuevo) {
        if(!nodos.containsKey(id)) {
            return false;
        }
        nodos.replace(id, nuevo);
        return true;
    }
    
    public boolean borrarNodo(String id) {
        if(!nodos.containsKey(id)) {
            return false;
        }
        nodos.remove(id);
        return true;
    }
    
}
