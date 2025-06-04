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
    public boolean searchVertex(E v) {
        Vertex<E> vertex = new Vertex<>(v);
        return listVertex.contains(vertex);
    }

    public String toString() {
        return this.listVertex.toString();
    }
}
