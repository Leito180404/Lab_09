package Ejercicios.graph;

import java.util.ArrayList;

public class VertexObj<V, E> {
    protected V info;
    protected int position;
    public ArrayList<EdgeObj<V, E>> secEdge;

    public VertexObj(V info, int position) {
        this.info = info;
        this.position = position;
        this.secEdge = new ArrayList<EdgeObj<V, E>>();
    }
    // otros métodos
}

