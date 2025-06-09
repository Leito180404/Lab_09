package Ejercicios;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphLink1<E> {

    protected ListLinked1<Vertex1<E>> listVertex;

    public GraphLink1() {
        listVertex = new ListLinked1<Vertex1<E>>();
    }

    public void insertVertex(E data) {
        Vertex1<E> v = new Vertex1<E>(data);
        if (listVertex.indexOf(v) < 0) {
            listVertex.addLast(v);
        }
    }

    public void insertEdge(E verOri, E verDes) {
        Vertex1<E> origen = null;
        Vertex1<E> destino = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> v = listVertex.get(i);
            if (v.getData().equals(verOri)) {
                origen = v;
                break;
            }
        }

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> v = listVertex.get(i);
            if (v.getData().equals(verDes)) {
                destino = v;
                break;
            }
        }

        if (origen != null && destino != null) {
            Edge1<E> edge1 = new Edge1<>(destino);
            if (!origen.listAdj.contains(edge1)) {
                origen.listAdj.addLast(edge1);
            }

            Edge1<E> edge2 = new Edge1<>(origen);
            if (!destino.listAdj.contains(edge2)) {
                destino.listAdj.addLast(edge2);
            }
        }
    }

    public boolean searchVertex(E v) {
        Vertex1<E> vertex = new Vertex1<>(v);
        return listVertex.contains(vertex);
    }

    public boolean searchEdge(E v, E z) {
        Vertex1<E> vertex = new Vertex1<>(v);
        int pos = listVertex.indexOf(vertex);
        if (pos >= 0) {
            Vertex1<E> vert = listVertex.get(pos);
            Edge1<E> edge = new Edge1<>(new Vertex1<>(z));
            return vert.listAdj.contains(edge);
        }
        return false;
    }

    public void removeVertex(E v) {
        Vertex1<E> vertex = new Vertex1<>(v);
        int pos = listVertex.indexOf(vertex);
        if (pos >= 0) {
            for (int i = 0; i < listVertex.size(); i++) {
                Vertex1<E> currentVertex = listVertex.get(i);
                currentVertex.listAdj.remove(new Edge1<>(vertex));
            }
            listVertex.remove(vertex);
        }
    }

    public boolean removeEdge(E v, E z) {
        if (!searchVertex(v) || !searchVertex(z)) return false;
        Vertex1<E> vertV = null;
        Vertex1<E> vertZ = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> current = listVertex.get(i);
            if (current.getData().equals(v)) vertV = current;
            if (current.getData().equals(z)) vertZ = current;
        }

        if (vertV == null || vertZ == null) return false;

        boolean removedFromV = vertV.listAdj.remove(new Edge1<>(vertZ));
        boolean removedFromZ = vertZ.listAdj.remove(new Edge1<>(vertV));

        return removedFromV && removedFromZ;
    }

    public void dfs(E v) {
        Vertex1<E> vertex = new Vertex1<>(v);
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

    private void dfsRecursive(Vertex1<E> vertex) {
        vertex.visited = true;
        System.out.println("Visitando vertice: " + vertex.getData());

        for (int i = 0; i < vertex.listAdj.size(); i++) {
            Edge1<E> edge = vertex.listAdj.get(i);
            Vertex1<E> adjVertex = edge.refDest;
            if (!adjVertex.visited) {
                dfsRecursive(adjVertex);
            }
        }
    }

    public void bfs(E v) {
        Vertex1<E> startVertex = new Vertex1<>(v);
        int pos = listVertex.indexOf(startVertex);
        if (pos < 0) {
            System.out.println("Vertice no encontrado.");
            return;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }

        Queue<Vertex1<E>> queue = new LinkedList<>();
        Vertex1<E> currentVertex = listVertex.get(pos);
        queue.add(currentVertex);
        currentVertex.visited = true;

        System.out.println("Realizando BFS a partir del vertice " + v + "...");
        while (!queue.isEmpty()) {
            Vertex1<E> vertex = queue.poll();
            System.out.println("Visitando vertice: " + vertex.getData());

            for (int i = 0; i < vertex.listAdj.size(); i++) {
                Edge1<E> edge = vertex.listAdj.get(i);
                Vertex1<E> adjVertex = edge.refDest;
                if (!adjVertex.visited) {
                    adjVertex.visited = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    public List<E> bfsPath(E v, E z) {
        Vertex1<E> startVertex = new Vertex1<>(v);
        Vertex1<E> targetVertex = new Vertex1<>(z);
        int startPos = listVertex.indexOf(startVertex);
        int targetPos = listVertex.indexOf(targetVertex);

        if (startPos < 0 || targetPos < 0) {
            System.out.println("Vertice no encontrado.");
            return null;
        }

        for (int i = 0; i < listVertex.size(); i++) {
            listVertex.get(i).visited = false;
        }

        Queue<Vertex1<E>> queue = new LinkedList<>();
        Map<Vertex1<E>, Vertex1<E>> parentMap = new HashMap<>();
        Vertex1<E> currentVertex = listVertex.get(startPos);
        queue.add(currentVertex);
        currentVertex.visited = true;

        while (!queue.isEmpty()) {
            Vertex1<E> vertex = queue.poll();

            if (vertex.equals(listVertex.get(targetPos))) {
                List<E> path = new LinkedList<>();
                Vertex1<E> current = vertex;
                while (current != null) {
                    path.add(0, current.getData());
                    current = parentMap.get(current);
                }
                return path;
            }

            for (int i = 0; i < vertex.listAdj.size(); i++) {
                Edge1<E> edge = vertex.listAdj.get(i);
                Vertex1<E> adjVertex = edge.refDest;
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

    public void insertEdgeWeight(E verOri, E verDes, int w) {
        Vertex1<E> origen = null;
        Vertex1<E> destino = null;

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> v = listVertex.get(i);
            if (v.getData().equals(verOri)) {
                origen = v;
                break;
            }
        }

        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> v = listVertex.get(i);
            if (v.getData().equals(verDes)) {
                destino = v;
                break;
            }
        }

        if (origen != null && destino != null) {
            Edge1<E> edge1 = new Edge1<>(destino, w);
            if (!origen.listAdj.contains(edge1)) {
                origen.listAdj.addLast(edge1);
            }

            Edge1<E> edge2 = new Edge1<>(origen, w);
            if (!destino.listAdj.contains(edge2)) {
                destino.listAdj.addLast(edge2);
            }
        }
    }

    public List<E> shortPath(E v, E z) {
        List<E> path = Dijkstra(v, z);
        if (path == null || path.isEmpty()) {
            System.out.println("No existe un camino entre los vertices " + v + " y " + z);
        } else {
            System.out.println("Camino mas corto entre los vertices " + v + " y " + z + ": " + path);
        }
        return path;
    }

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

    public List<E> Dijkstra(E v, E w) {
        Vertex1<E> start = new Vertex1<>(v);
        Vertex1<E> end = new Vertex1<>(w);

        int startPos = listVertex.indexOf(start);
        int endPos = listVertex.indexOf(end);

        if (startPos < 0 || endPos < 0) {
            System.out.println("Vértice no encontrado.");
            return null;
        }

        Map<Vertex1<E>, Integer> dist = new HashMap<>();
        Map<Vertex1<E>, Vertex1<E>> parentMap = new HashMap<>();
        for (int i = 0; i < listVertex.size(); i++) {
            dist.put(listVertex.get(i), Integer.MAX_VALUE);  
            parentMap.put(listVertex.get(i), null);
        }
        dist.put(listVertex.get(startPos), 0); 

        PriorityQueue<Vertex1<E>> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        pq.add(listVertex.get(startPos)); 

        Set<Vertex1<E>> processed = new HashSet<>(); 

        while (!pq.isEmpty()) {
            Vertex1<E> currentVertex = pq.poll();

            if (processed.contains(currentVertex)) {
                continue;
            }

            processed.add(currentVertex);

            System.out.println("Procesando vértice: " + currentVertex.getData());
            System.out.println("Distancias actuales: " + dist);

            for (Edge1<E> edge : currentVertex.listAdj) {
                Vertex1<E> adjVertex = edge.refDest;
                int newDist = dist.get(currentVertex) + edge.weight;

                if (newDist < dist.get(adjVertex)) {
                    dist.put(adjVertex, newDist);
                    parentMap.put(adjVertex, currentVertex);

                    System.out.println("Actualizando distancia para " + adjVertex.getData() + ": " + newDist);
                    pq.add(adjVertex);
                }
            }
        }

        List<E> shortestPath = new ArrayList<>();
        Vertex1<E> current = listVertex.get(endPos);
        while (current != null) {
            shortestPath.add(0, current.getData());
            current = parentMap.get(current);
        }

        if (shortestPath.isEmpty()) {
            System.out.println("No existe un camino entre los vértices.");
            return null;
        }

        System.out.println("Camino más corto encontrado: " + shortestPath);
        return shortestPath;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listVertex.size(); i++) {
            Vertex1<E> vertex = listVertex.get(i);
            sb.append(vertex.getData()).append(" --> ");
            
            for (int j = 0; j < vertex.listAdj.size(); j++) {
                Edge1<E> edge = vertex.listAdj.get(j);
                sb.append(edge.refDest.getData()).append("[").append(edge.weight).append("], ");
            }
            
            sb.append("\n");
        }
        return sb.toString();
    }

}



