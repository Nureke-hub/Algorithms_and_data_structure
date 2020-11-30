package com.company;

public class Edge<T extends  Comparable<T>>{
    private T vertex = null;
    private int weight;

    public Edge(T vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    public T getVertex() {
        return vertex;
    }

    public void setVertex(T vertex) {
        this.vertex = vertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
        return "( "+ vertex + " )";
    }
}



