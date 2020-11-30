package com.company.Task3;

public class SortedLinkedList<T extends Comparable>{
    private NodeC<T> head = null;
    private int size = 0;

    public SortedLinkedList() {}
    
    public void addSorted(T data){
        NodeC<T> node = new NodeC<T>(data);
        if(size == 0){
            head = node;
        }else if(head.getData().compareTo(data) == 0 || head.getData().compareTo(data) > 0){
            node.setNext(head);
            head = node;
        }else{
            NodeC<T> last = head;
            while (last != null){
                if(last.getNext() == null){
                    last.setNext(node);
                    break;
                } else if((last.getData().compareTo(data) < 0 || last.getData().compareTo(data) == 0) && last.getNext().getData().compareTo(data) > 0) {
                    node.setNext(last.getNext());
                    last.setNext(node);
                    break;
                }
                last = last.getNext();
            }
        }
        size++;
    }

    public void remove(int i) {
        NodeC<T> last = head;
        int count = 0;
        if (i >= size || i < 0) {
            System.out.println("Wrong! Such an element does not exist!");
            System.out.println("Unfortunately we can't remove the item under index " + i);
        } else if(i == 0){
            remove();
        }else {
            while (count != i -1) {
                last = last.getNext();
                count++;
            }
            last.setNext(last.getNext().getNext());
        }
    }

    public void remove(){
        head = head.getNext();
    }

    @Override
    public String toString() {
        String str = "";
        NodeC<T> current = head;
        while (current != null){
            str += (current.getData() + "\n");
            current = current.getNext();
        }
        return str;
    }
}
