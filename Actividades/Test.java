package Actividades;

import Actividades.graph.GraphLink;

public class Test {
    public static void main(String[] args) {
        GraphLink<Integer> graph = new GraphLink<>();

        System.out.println("Insertando vertices...");
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        System.out.println("\ngrafo despues de insertar vertices:");
        System.out.println(graph);
    
        System.out.println("\nBuscando el vertice 2: " + graph.searchVertex(2));
        System.out.println("Buscando el vertice 5: " + graph.searchVertex(5));
    }
        
        
}
