package Ejercicios;
import java.util.Scanner;

import Ejercicios.graph.GraphListEdge;
import Ejercicios.graph.VertexObj;

public class Test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear el grafo
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();

        // Agregar vértices al grafo
        VertexObj<String, Integer> vertex1 = new VertexObj<>("A", 1);
        VertexObj<String, Integer> vertex2 = new VertexObj<>("B", 2);
        VertexObj<String, Integer> vertex3 = new VertexObj<>("C", 3);
        VertexObj<String, Integer> vertex4 = new VertexObj<>("D", 4);
        
        graph.insertVertex(vertex1);
        graph.insertVertex(vertex2);
        graph.insertVertex(vertex3);
        graph.insertVertex(vertex4);

        // Agregar aristas al grafo
        graph.insertEdge(vertex1, vertex2);
        graph.insertEdge(vertex2, vertex3);
        graph.insertEdge(vertex3, vertex4);

        // Menu para opciones
        boolean running = true;
        while (running) {
            System.out.println("\nElige una opcion:");
            System.out.println("1. Verificar si el grafo es isomorfo con otro grafo.");
            System.out.println("2. Verificar si el grafo es plano.");
            System.out.println("3. Verificar si el grafo es conexo.");
            System.out.println("4. Verificar si el grafo es auto complementario.");
            System.out.println("5. Salir.");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nVerificando si el grafo es isomorfo...");
                    boolean isIsomorphic = graph.isIsomorphic(graph);
                    System.out.println("¿Es isomorfo? " + isIsomorphic);
                    break;

                case 2:
                    System.out.println("\nVerificando si el grafo es plano...");
                    boolean isPlanar = graph.isPlanar();
                    System.out.println("¿Es plano? " + isPlanar);
                    break;

                case 3:
                    System.out.println("\nVerificando si el grafo es conexo...");
                    boolean isConnected = graph.isConnected();
                    System.out.println("¿Es conexo? " + isConnected);
                    break;

                case 4:
                    System.out.println("\nVerificando si el grafo es auto complementario...");
                    boolean isAutocomplementary = graph.isAutocomplementary();
                    System.out.println("¿Es auto complementario? " + isAutocomplementary);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    running = false;
                    break;

                default:
                    System.out.println("Opcion no valida, por favor intenta nuevamente.");
            }
        }

        scanner.close();
    }
}
