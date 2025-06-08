package Ejercicios;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import Actividades.ListLinked;
import Actividades.graph.Edge;
import Actividades.graph.Vertex;

public class GraphLink1<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink1() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        Vertex<E> v = new Vertex<E>(data);
        if (listVertex.indexOf(v) < 0) {
            listVertex.addLast(v);
        }
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex<E> origen = null;
        Vertex<E> destino = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            if (v.getData().equals(verOri)) {
                origen = v;
                break;
            }
        }

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            if (v.getData().equals(verDes)) {
                destino = v;
                break;
            }
        }

        if (origen != null && destino != null) {
            Edge<E> edge1 = new Edge<>(destino);
            if (!origen.listAdj.contains(edge1)) {
                origen.listAdj.addLast(edge1);
            }

            Edge<E> edge2 = new Edge<>(origen);
            if (!destino.listAdj.contains(edge2)) {
                destino.listAdj.addLast(edge2);
            }
        }
    }
    //Actividad 2.1.a
    public boolean searchVertex(E v) {
        Vertex<E> vertex = new Vertex<>(v);
        return listVertex.contains(vertex);
    }

    //Actividad 2.1.b
    public boolean searchEdge(E v, E z) {
        Vertex<E> vertex = new Vertex<>(v);
        int pos = listVertex.indexOf(vertex);
        if (pos >= 0) {
            Vertex<E> vert = listVertex.get(pos);
            Edge<E> edge = new Edge<>(new Vertex<>(z));
            return vert.listAdj.contains(edge);
        }
        return false;
    }

    //Actividad 2.2.a
    public void removeVertex(E v) {
        Vertex<E> vertex = new Vertex<>(v);
        int pos = listVertex.indexOf(vertex);
        if (pos >= 0) {
            for (int i = 0; i < listVertex.size(); i++) {
                Vertex<E> currentVertex = listVertex.get(i);
                currentVertex.listAdj.remove(new Edge<>(vertex));
            }
            listVertex.remove(vertex);
        }
    }

    //actividad 2.2.b
    public boolean removeEdge(E v, E z) {
        if (!searchVertex(v) || !searchVertex(z)) return false;
        Vertex<E> vertV = null;
        Vertex<E> vertZ = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> current = listVertex.get(i);
            if (current.getData().equals(v)) vertV = current;
            if (current.getData().equals(z)) vertZ = current;
        }

        if (vertV == null || vertZ == null) return false;

        boolean removedFromV = vertV.listAdj.remove(new Edge<>(vertZ));
        boolean removedFromZ = vertZ.listAdj.remove(new Edge<>(vertV));

        return removedFromV && removedFromZ;
    }

    //actividad 2.2.c

    public void dfs(E v) {
        Vertex<E> vertex = new Vertex<>(v);
        int pos = listVertex.indexOf(vertex);
        if (pos < 0) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }
        dfsRecursive(listVertex.get(pos));
    }

    private void dfsRecursive(Vertex<E> vertex) {
        vertex.visited = true;
        System.out.println("Visitando vertice: " + vertex.getData());

        for (int i = 0; i < vertex.listAdj.size(); i++) {
            Edge<E> edge = vertex.listAdj.get(i);
            Vertex<E> adjVertex = edge.refDest;
            if (!adjVertex.visited) {
                dfsRecursive(adjVertex);
            }
        }
    }


    //ejercicio 1.a
    public void bfs(E v) {
        Vertex<E> startVertex = new Vertex<>(v);
        int pos = listVertex.indexOf(startVertex);
        if (pos < 0) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }

        Queue<Vertex<E>> queue = new LinkedList<>();
        Vertex<E> currentVertex = listVertex.get(pos);
        queue.add(currentVertex);
        currentVertex.visited = true;

        System.out.println("Realizando BFS a partir del vertice " + v + "...");
        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();
            System.out.println("Visitando vertice: " + vertex.getData());

            for (int i = 0; i < vertex.listAdj.size(); i++) {
                Edge<E> edge = vertex.listAdj.get(i);
                Vertex<E> adjVertex = edge.refDest;
                if (!adjVertex.visited) {
                    adjVertex.visited = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    //ejercicio 1.b
    public List<E> bfsPath(E v, E z) {
        Vertex<E> startVertex = new Vertex<>(v);
        Vertex<E> targetVertex = new Vertex<>(z);
        int startPos = listVertex.indexOf(startVertex);
        int targetPos = listVertex.indexOf(targetVertex);

        if (startPos < 0 || targetPos < 0) {
            System.out.println("Vertice no encontrado.");
            return null;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }

        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();
        Vertex<E> currentVertex = listVertex.get(startPos);
        queue.add(currentVertex);
        currentVertex.visited = true;

        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();

            if (vertex.equals(listVertex.get(targetPos))) {
                List<E> path = new LinkedList<>();
                Vertex<E> current = vertex;
                while (current != null) {
                    path.add(0, current.getData());
                    current = parentMap.get(current);
                }
                return path;
            }

            for (int i = 0; i < vertex.listAdj.size(); i++) {
                Edge<E> edge = vertex.listAdj.get(i);
                Vertex<E> adjVertex = edge.refDest;
                if (!adjVertex.visited) {
                    adjVertex.visited = true;
                    queue.add(adjVertex);
                    parentMap.put(adjVertex, vertex);
                }
            }
        }

        System.out.println("No hay camino entre los vertices.");
        return null;
    }


    // Ejercicio 2.a
    public void insertEdgeWeight(E verOri, E verDes, int w) {
        Vertex<E> origen = null;
        Vertex<E> destino = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            if (v.getData().equals(verOri)) {
                origen = v;
                break;
            }
        }

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex<E> v = listVertex.get(i);
            if (v.getData().equals(verDes)) {
                destino = v;
                break;
            }
        }

        if (origen != null && destino != null) {
            Edge<E> edge1 = new Edge<>(destino, w);
            if (!origen.listAdj.contains(edge1)) {
                origen.listAdj.addLast(edge1);
            }

            Edge<E> edge2 = new Edge<>(origen, w);
            if (!destino.listAdj.contains(edge2)) {
                destino.listAdj.addLast(edge2);
            }
        }
    }

    // Ejercicio 2.b
    public List<E> shortPath(E v, E z) {
        Vertex<E> startVertex = new Vertex<>(v);
        Vertex<E> targetVertex = new Vertex<>(z);
        
        int startPos = listVertex.indexOf(startVertex);
        int targetPos = listVertex.indexOf(targetVertex);

        if (startPos < 0 || targetPos < 0) {
            System.out.println("Vertice no encontrado.");
            return null;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }
        Queue<Vertex<E>> queue = new LinkedList<>();
        Map<Vertex<E>, Vertex<E>> parentMap = new HashMap<>();
        
        Vertex<E> start = listVertex.get(startPos);
        queue.add(start);
        start.visited = true;
        
        while (!queue.isEmpty()) {
            Vertex<E> vertex = queue.poll();
            
            if (vertex.equals(listVertex.get(targetPos))) {
                List<E> path = new ArrayList<>();
                Vertex<E> current = vertex;
                while (current != null) {
                    path.add(0, current.getData());
                    current = parentMap.get(current);
                }
                return path;
            }
            for (int i = 0; i < vertex.listAdj.size(); i++) {
                Edge<E> edge = vertex.listAdj.get(i);
                Vertex<E> adjVertex = edge.refDest;
                
                if (!adjVertex.visited) {
                    adjVertex.visited = true;
                    queue.add(adjVertex);
                    parentMap.put(adjVertex, vertex);
                }
            }
        }
        System.out.println("No hay camino entre los vertices.");
        return null;
    }

    // Ejercicio 2.c

    public boolean isConexo() {
        for (int i = 0; i < listVertex.size(); i++) {
            for (int j = 0; j < listVertex.size(); j++) {
                listVertex.get(j).visited = false;
            }
            dfs(listVertex.get(i).getData());
            for (int k = 0; k < listVertex.size(); k++) {
                if (!listVertex.get(k).visited) {
                    return false;
                }
            }
        }
        return true;
    }

    // Ejercicio 2.d
    public List<E> Dijkstra(E v, E w) {
        Vertex<E> start = new Vertex<>(v);
        Vertex<E> end = new Vertex<>(w);

        int startPos = listVertex.indexOf(start);
        int endPos = listVertex.indexOf(end);

        if (startPos < 0 || endPos < 0) {
            System.out.println("Vertice no encontrado.");
            return null;
        }
        List<E> shortestPath = new ArrayList<>();
        return shortestPath;
    }


    public String toString() {
        return this.listVertex.toString();
    }
}

