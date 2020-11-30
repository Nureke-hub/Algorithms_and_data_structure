package com.company;

public class Edge<T extends  Comparable<T>>{
    private T vertex = null;

    public Edge(T vertex, int weight) {
        this.vertex = vertex;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public String toString(){
        return "( "+ vertex + " )";
    }
}



