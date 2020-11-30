package com.company.ArrayDeque;


import java.util.Arrays;

public class ArrayDeque<T extends Comparable<T>>{
    private T[] deque = null;
    private int length = 16;
    private int size = 0;
    private int head = -1;
    private int last = -1;

    public ArrayDeque() {
        deque = (T[])new Comparable[length];
    }
    public ArrayDeque(int i){
        deque = (T[]) new Comparable[i];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public T first(){
        if(head != -1){
            return deque[head];
        }
        return null;
    }

    public T last(){
        return deque[last];
    }

    public void doubleCapacity(){
        if(!isEmpty()){
            T[] arr = (T[])new Comparable[length * 2];
            for(int i = head, j = 0; i != last && j < size; i = (i+1)%length, j++){
                arr[j] = deque[i];
            }
            head = 0;
            last = size -1;
        }else {
            T[] arr = (T[])new Comparable[length + 16];
        }
        length = length * 2;
    }

    public void addFirst(T obj){
        if(size == length) {
            doubleCapacity();
        }
        if(head == -1){
            head = 0;
        }
        if(head == 0){
            head = length - 1;
        }else {
            head = head - 1;
        }
        deque[head] = obj;
        size++;
    }

    public void addLast(T data){
        if(size == length) {
            doubleCapacity();
        }
        if (head == -1 && last == -1){
            head = 0;
            last = 0;
        }else{
            if(last == length - 1)
                last = 0; // need to thing
            else last = last + 1;
        }
        deque[last] = data;
        size++;
    }

    public void removeFirst(){
        if(isEmpty()){
            System.out.println("We don't have data");
        }else{
            deque[head] = null;
            if(head == length - 1){
                head = 0;
            }else{
                head = head + 1;
            }
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty()){
            System.out.println("We din't have data");
        }else{
            deque[last] = null;
            if(last == 0){
                last = length -1;
            }else{
                last = last - 1;
            }
        }
        size--;
    }

    @Override
    public String toString() {
        return "ArrayDeque{" +
                "deque=" + Arrays.toString(deque) +
                '}';
    }

//        @Override
//    public String toString() {
//        String str = "";
//            for(int i = head,j = 0; i != last && j < size; i = (i + 1)%length, j++){
//                str += deque[i] + "\n";
//            }
//        return str;
//    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }
}


