package com.company.Task2;

import java.util.Arrays;

public class Wallet implements Comparable<Wallet>{
    private Money arr[];
    private int n;
    private int size;

    public Wallet() {
        this.arr = new Money[5];
        size = 5;
        n = 0;
    }

    public Wallet(Money[] arr) {
        this.arr = arr;
    }

    public Wallet(int size) {
        this.arr = new Money[size];
        this.size = size;
        n = 0;
    }

    public Money get(int i){
        try{
            return arr[i];
        }
        catch (OutOfMemoryError out){
            System.out.println("An item under such an index does not exist!");
            System.out.println("Last element of an array: ");
            return arr[n - 1];
        }

    }

    public int size(){
        return n;
    }

    public void add(Money m){
        if (n == size){
            Money arr2[] = new Money[size + 5];
            for (int i = 0; i < n; i++){
                arr2[i] = arr[i];
            }
            arr = arr2;
            this.size += 5;
        }
        arr[n] = m;
        n++;
    }

    public double sum(){
        double sum = 0;
        for(int i = 0; i < n; i++){
            sum+= arr[i].toTenge();
        }
        return sum;
    }

    private int partition(Money[] arr, int low, int high) {
        Money pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j].compareTo(pivot) == -1) {
                i++;
                Money temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Money temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    private void quickSort(Money[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr,low, pi-1);
            quickSort(arr,pi+1, high);
        }
    }

    public void sort(){
        quickSort(this.arr, 0, n-1);
    }

    public void remove(int x){
        try{
            for(int i = x; i < n-1; i++){
                arr[i] = arr[i +1];
            }
        }
        catch (OutOfMemoryError out){
            out.printStackTrace();
        }
    }

    @Override
    public int compareTo(Wallet wallet) {
        if(this.sum() > wallet.sum()){
            return 1;
        } else if (this.sum() < wallet.sum()){
            return -1;
        }else{
            return 0;
        }
    }


    @Override
    public String toString() {
        return "Wallet: "+ Arrays.toString(arr);
    }
}
