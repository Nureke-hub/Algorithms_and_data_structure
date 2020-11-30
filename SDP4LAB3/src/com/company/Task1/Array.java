package com.company.Task1;

public class Array<T extends Comparable<T>> {
    private T arr[];
    private int size;
    private int n = 0;

    public Array() {
        this(10);
    }

    public Array(int size) {
        this.arr = (T[]) new Comparable[size];
    }

    public T get(int i){
        return arr[i];
    }

    public int size(){
        return n;
    }

    public void add(T obj){
        if(size == n){
            T arr2[] = (T[]) new Comparable[size + 10];
            for(int i = 0; i < n; i++){
                arr2[i] = arr[i];
            }
            arr = arr2;
            this.size += 10;
        }
        arr[n] = obj;
        n++;
    }

    public void remove(int x){
        for (int i = x; i < n - 1; i++){
            arr[i] = arr[i + 1];
        }
        n--;
    }

    public int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j].compareTo(pivot) == -1) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        T temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;

    }
    public void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr,low, pi-1);
            quickSort(arr,pi+1, high);
        }
    }

    public void sort(){
        quickSort(this.arr, 0, n-1);
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < n; i++){
            str += (arr[i] + "\n");
        }
        return str;
    }
}

