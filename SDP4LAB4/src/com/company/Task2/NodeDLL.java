package com.company.Task2;

public class NodeDLL<T> {
    private T data;
    private NodeDLL<T> next = null;
    private NodeDLL<T> previous = null;

    public NodeDLL(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeDLL<T> getNext() {
        return next;
    }

    public void setNext(NodeDLL<T> next) {
        this.next = next;
    }

    public NodeDLL<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeDLL<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return  "" + data;
    }
}
