package Actividades.graph;
import Actividades.ListLinked;
public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
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


    public String toString() {
        return this.listVertex.toString();
    }
}
