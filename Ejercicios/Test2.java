package Ejercicios;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        GraphLink1<Integer> graph = new GraphLink1<>();

        System.out.println("Insertando vertices...");
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(3, 4);

        // Ejercicio 2.a: Probando insertEdgeWeight
        System.out.println("\nEjercicio 2.a: Insertando aristas con peso...");
        graph.insertEdgeWeight(1, 2, 10);
        graph.insertEdgeWeight(2, 3, 20);
        graph.insertEdgeWeight(3, 4, 30);
        System.out.println("Grafo despues de insertar aristas con peso:");
        System.out.println(graph);

        // Ejercicio 2.b: Probando shortPath
        System.out.println("\nEjercicio 2.b: Buscando el camino mas corto entre los vertices 1 y 4...");
        List<Integer> path = graph.shortPath(1, 4);
        if (path != null) {
            System.out.println("Camino mas corto: " + path);
        } else {
            System.out.println("No existe un camino entre los vertices.");
        }

        // Ejercicio 2.c: Probando isConexo
        System.out.println("\nEjercicio 2.c: Comprobando si el grafo es conexo...");
        boolean isConnected = graph.isConexo();
        System.out.println("El grafo es conexo: " + isConnected);

        // Ejercicio 2.d: Probando Dijkstra
        System.out.println("\nEjercicio 2.d: Buscando el camino mas corto usando Dijkstra entre los vertices 1 y 4...");
        List<Integer> dijkstraPath = graph.Dijkstra(1, 4);
        if (dijkstraPath != null) {
            System.out.println("Camino mas corto usando Dijkstra: " + dijkstraPath);
        } else {
            System.out.println("No existe un camino entre los vertices.");
        }
    }
}

