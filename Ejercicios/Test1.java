package Ejercicios;
import java.util.List;
public class Test1 {
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

        System.out.println("\nGrafo despues de insertar vertices y aristas:");
        System.out.println(graph);

        System.out.println("\nEjercicio 1.a: Realizando BFS a partir del vertice 1...");
        graph.bfs(1);

        System.out.println("\nEjercicio 1.b: Buscando el camino entre los vertices 1 y 3...");
        List<Integer> path = graph.bfsPath(1, 3);
        if (path != null) {
            System.out.println("Camino: " + path);
        } else {
            System.out.println("No se encontro camino entre los vertices.");
        }
    }
}

