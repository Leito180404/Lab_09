package Ejercicios;
import Ejercicios.graph.*;
import java.util.Scanner;

public class Test8Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear el grafo no dirigido
        GraphListEdge<String, Integer> graph = new GraphListEdge<>();

        // Crear los vértices
        VertexObj<String, Integer> A = new VertexObj<>("A", 1);
        VertexObj<String, Integer> B = new VertexObj<>("B", 2);
        VertexObj<String, Integer> C = new VertexObj<>("C", 3);
        VertexObj<String, Integer> D = new VertexObj<>("D", 4);
        VertexObj<String, Integer> E = new VertexObj<>("E", 5);

        // Insertar vértices
        graph.insertVertex(A);
        graph.insertVertex(B);
        graph.insertVertex(C);
        graph.insertVertex(D);
        graph.insertVertex(E);

        // Agregar algunas aristas
        graph.insertEdge(A, B);
        graph.insertEdge(A, C);
        graph.insertEdge(B, D);
        graph.insertEdge(C, D);
        graph.insertEdge(D, E);

        // Menú interactivo
        while (true) {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Ver representación formal del grafo");
            System.out.println("2. Ver lista de adyacencia");
            System.out.println("3. Ver matriz de adyacencia");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de scanner

            switch (opcion) {
                case 1: // Mostrar la representación formal
                    graph.printFormal();
                    break;

                case 2: // Mostrar lista de adyacencia
                    graph.printAdjacencyList();
                    break;

                case 3: // Mostrar matriz de adyacencia
                    graph.printAdjacencyMatrix();
                    break;

                case 4: // Salir del programa
                    System.out.println("¡Adiós!");
                    return;

                default:
                    System.out.println("Opcion no valida. Por favor, selecciona una opcion valida.");
            }
        }
    }
}

