
package test;

import java.util.*;


public class TestColeccionesGenericas {
    public static void main(String[] args) {
        List<String>miLista = new ArrayList<>();
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        imprimir(miLista);
        System.out.println("");
        
        Set<String> miSet = new HashSet<>();
        miSet.add("Monday");
        miSet.add("Tuesday");
        miSet.add("Wednesday");
        miSet.add("Thursday");
        miSet.add("Friday");
        imprimir(miSet);
        
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Omar", 24);
        mapa.put("Bad", 1987);
        mapa.put("Thriller", 1982);
        
    
    }
    public static void imprimir(Collection coleccion){
        for (Object i: coleccion) {
            System.out.println("i = " + i);
        }
    }
}
