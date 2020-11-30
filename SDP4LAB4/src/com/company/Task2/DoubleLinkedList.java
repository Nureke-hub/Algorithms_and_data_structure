package com.company.Task2;
import java.util.Iterator;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private NodeDLL<T> head = null;
    private NodeDLL<T> tail = null;
    private int size = 0;

    public void add(T data, boolean bool){
        NodeDLL<T> nodeDLL = new NodeDLL<>(data);
        if(size == 0){
            head = nodeDLL;
            tail = nodeDLL;
        }else{
            if(bool){
                head.setPrevious(nodeDLL);
                nodeDLL.setNext(head);
                head = nodeDLL;
            }else {
                nodeDLL.setPrevious(tail);
                tail.setNext(nodeDLL);
                tail = nodeDLL;
            }
        }
        size++;
    }
    public void add(T data, int index){
        NodeDLL<T> nodeDLL = new NodeDLL<>(data);
        if (index > size){
            System.out.println("Index out of bound!");
            System.out.println("We will add data to the end.");
            add(data, false);
        } else if(index == 0){
            add(data, true);
        }else if(index == size){
            add(data, false);
        }else{
            if(index < size/2){
                NodeDLL<T> last = head;
                int count = 1;
                while (count != index){
                    last = last.getNext();
                    count++;
                }
                nodeDLL.setNext(last.getNext());
                last.getNext().setPrevious(nodeDLL);
                nodeDLL.setPrevious(last);
                last.setNext(nodeDLL);
            } else if(index >= size/2){
                int count = size - 1;
                NodeDLL<T> first = tail;
                while (count != index){
                    count--;
                    first = first.getPrevious();
                }
                nodeDLL.setNext(first);
                nodeDLL.setPrevious(first.getPrevious());
                first.getPrevious().setNext(nodeDLL);
                first.setPrevious(nodeDLL);
            }
        }
        size++;
    }

    public void set(int index, T data){
        NodeDLL<T> nodeDLL = new NodeDLL<>(data);
        if(index >= size){
            System.out.println("Unable to set to the specified index");
        }else{
            if(index < size/2){
                NodeDLL<T> last = head;
                if(index == 0){
                    nodeDLL.setNext(head.getNext());
                    head.getNext().setPrevious(nodeDLL);
                    head = nodeDLL;
                }else{
                    int count = 1;
                    while (count != index){
                        last = last.getNext();
                        count++;
                    }
                    nodeDLL.setNext(last.getNext().getNext());
                    last.getNext().getNext().setPrevious(nodeDLL);
                    nodeDLL.setPrevious(last);
                    last.setNext(nodeDLL);
                }
            } else {
                if(index == size -1){
                    nodeDLL.setPrevious(tail.getPrevious());
                    tail.getPrevious().setNext(nodeDLL);
                    tail = nodeDLL;
                }else{
                    NodeDLL<T> first = tail;
                    int count = size-2;
                    while (count != index){
                        first = first.getPrevious();
                        count--;
                    }
                    nodeDLL.setPrevious(first.getPrevious().getPrevious());
                    first.getPrevious().getPrevious().setNext(nodeDLL);
                    nodeDLL.setNext(first);
                    first.setPrevious(nodeDLL);
                }
            }
        }
    }

    public T get(int index){
        if (index > size){
            System.out.println("Index out of bound!");
        }else{
            if(index < size/2){
                int count = 0;
                NodeDLL<T> last = head;
                while (count != index){
                    last = last.getNext();
                    count++;
                }
                return last.getData();
            }else{
                int count = size -1;
                NodeDLL<T> first = tail;
                while (count != index){
                    first = first.getPrevious();
                    count--;
                }
                return first.getData();
            }
        }
        return null;
    }
    public T getFirst(){
        return head.getData();
    }
    public T getLast(){
        return tail.getData();
    }

    public void remove(boolean bool){
        if(bool){
            head = head.getNext();
            head.setPrevious(null);
        }else{
            tail = tail.getPrevious();
            tail.setNext(null);
        }
    }
    public void remove(int index) {
        if(index >= size){
            System.out.println("Incorrect index");
        }else if (index == 0) {
            remove(true);
        } else if (index == size - 1) {
            remove(false);
        } else {
            if (index < size / 2) {
                NodeDLL<T> last = head;
                int count = 0;
                while (count != index) {
                    last = last.getNext();
                    count++;
                }
                last.getNext().setPrevious(last.getPrevious());
                last.getPrevious().setNext(last.getNext());
            } else {
                NodeDLL<T> first = tail;
                int count = size - 1;
                while (count != index) {
                    count--;
                    first = first.getPrevious();
                }
                first.getNext().setPrevious(first.getPrevious());
                first.getPrevious().setNext(first.getNext());
            }
        }
    }

    public int size(){
        return size;
    }

    public void print(boolean bool){
        if(bool){
            NodeDLL<T> last = head;
            while (last != null){
                System.out.println(last.getData());
                last = last.getNext();
            }
        }else{
            NodeDLL<T>first = tail;
            while (first != null){
                System.out.println(first.getData());
                first = first.getPrevious();
            }
        }
    }
    public String toString(){
        String str = "";
        NodeDLL<T> last = head;
        while (last != null){
            str += (last.getData() + "\n");
            last = last.getNext();
        }
        return str;
    }

    public void addList(DoubleLinkedList<T> list1, int index){
        NodeDLL<T> last = head;
        int count = 0;
        NodeDLL<T> lastList = list1.head;

        while (lastList.getNext() != null){
            lastList = lastList.getNext();
        }
        while (count != index -1){
            last = last.getNext();
            count++;
        }
        lastList.setNext(last.getNext());
        last.getNext().setPrevious(lastList);
        last.setNext(list1.head);
        list1.head.setPrevious(last);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this, true);
    }

    public Iterator<T> backwardIterator() {
        return new ListIterator<>(this, false);
    }

    public NodeDLL<T> getHead() {
        return head;
    }

    public NodeDLL<T> getTail() {
        return tail;
    }
}
