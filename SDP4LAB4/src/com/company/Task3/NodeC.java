package com.company.Task3;

public class NodeC<T extends Comparable> {

    private T data;
    private NodeC<T> next = null;

    public NodeC(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeC<T> getNext() {
        return next;
    }

    public void setNext(NodeC<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return  "" + data;
    }
}
