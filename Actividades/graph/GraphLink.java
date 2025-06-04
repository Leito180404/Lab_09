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
    }
    public String toString() {
        return this.listVertex.toString();
    }
}
