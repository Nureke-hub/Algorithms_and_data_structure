package com.company.Task2;

import java.util.Iterator;

public class ListIterator<T extends Comparable<T>> implements Iterator<T>{

    private NodeDLL<T> current;
    private boolean ishead;

    public ListIterator(DoubleLinkedList<T> doubleLinkedList, boolean ishead){
        if (ishead)
            current = doubleLinkedList.getHead();
        else
            current = doubleLinkedList.getTail();
        this.ishead = ishead;
}

    public boolean hasNext(){
        return current != null;
    }

    public T next(){
        if (hasNext()){
            T item = current.getData();
            if (ishead)
                current = current.getNext();
            else
                current = current.getPrevious();
            return item;
        }
        return null;
    }
}

