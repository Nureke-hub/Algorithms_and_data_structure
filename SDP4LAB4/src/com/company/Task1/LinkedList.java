package com.company.Task1;

public class LinkedList<T> {

    private Node<T> head = null;
    private int size = 0;

    public LinkedList() {}

    public void add(T data){
        if(size == 0){
            head = new Node<T>(data);
        }else {
            Node<T> last = head;
            while(last.getNext() != null){
                last = last.getNext();
            }
            last.setNext(new Node<T>(data));
        }
        size++;
    }

    public void add(int index, T data){
        Node<T> node = new Node<T>(data);
        Node<T> last = head;

        if(index == 0){
            node.setNext(head);
            head = node;
            size++;
        }
        else if (index == size) {
            add(data);
        }
        else if(index > size || index < 0){
            System.out.println("You want to add data to the wrong place!");
            System.out.println("We will add data to the last position.");
            add(data);
        }else{
            int count = 0;
            while(count != index - 1){
                last = last.getNext();
                count++;
            }
            node.setNext(last.getNext());
            last.setNext(node);
            size++;
        }
    }

    public void addAll(LinkedList<T> list2){
        if(size == 0){
            head = list2.head;
        }else {
            Node<T> last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(list2.head);
        }
        size += list2.size;
    }

    public void addFirst(T data){
        add(0, data);
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public String toString(){
        String str = "";
        Node<T> current = head;
        while (current != null){
            str += (current.getData() + "\n");
            current = current.getNext();
        }
        return str;
    }

    public LinkedList<T> getClone(){
        Node<T> last = head;
        LinkedList<T> list = new LinkedList<>();
        while (last != null){
            list.add(last.getData());
            last = last.getNext();
        }
        return list;
    }

    public T get(int index){
        Node<T> last = head;
        if(index >= size){
            System.out.println("No such item exists.");
            System.out.println("This is the last item in the linked list");
            return get(size - 1);
        } else {
            int i = 0;
            while (i != index) {
                last = last.getNext();
                i++;
            }
            return last.getData();
        }
    }

    public T getFirst(){
        return head.getData();
    }

    public T getLast(){
        return get(size -1);
    }

    public void remove(T data){
        if(size > 0){
            if(head.getData().equals(data)){
                head = head.getNext();
            }else{
                Node<T> current = head;
                while(current.getNext() != null){
                    if (current.getNext().getData().equals(data)){
                        current.setNext(current.getNext().getNext());
                        break;
                    }
                    current = current.getNext();
                }
            }
            size--;
        }else {
            System.out.println("List is empty");
        }
    }

    public void remove(int i) {
        Node<T> last = head;
        int count = 0;
        if (i >= size || i < 0) {
            System.out.println("Wrong! Such an element does not exist!");
            System.out.println("Unfortunately we can't remove the item under index " + i);
        } else if(i == 0){
            remove();
        }else {
            while (count != i - 1) {
                last = last.getNext();
                count++;
            }
            last.setNext(last.getNext().getNext());
        }
    }

    public void remove(){
        head = head.getNext();
    }

    public int size(){
        return size;
    }

    public void set(int i, T data){
        Node<T> last = head;
        Node<T> node = new Node<>(data);
        int count = 0;
        if(i == 0){
            node.setNext(head.getNext());
            head = node;
        }else{
            while (count != i - 1){
                last = last.getNext();
                count++;
            }
            node.setNext(last.getNext().getNext());
            last.setNext(node);
        }
    }

    public int indexOf(T data){
        Node<T> last = head;
        int index = 0;

        while (index != size){
            System.out.println(last.getData());
            if(last.getData().equals(data)){
                return index;
            }
            index++;
            last = last.getNext();
        }
        return -1;
    }

    public void addList(LinkedList<T> list1, int index){
        list1 = list1.getClone();
        Node<T> last = head;
        int count = 0;
        Node<T> lastList = list1.head;
        while (lastList.getNext() != null){
            lastList = lastList.getNext();
        }
        while (count != index){
            last = last.getNext();
            count++;
        }
        lastList.setNext(last.getNext());
        last.setNext(list1.head);
    }

}