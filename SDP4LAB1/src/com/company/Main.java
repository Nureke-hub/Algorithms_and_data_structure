package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    //Task 1
    public static void bubbleSort(){
        int arr[] = {23,34, 5, 2 ,4,25, 66, 32, 87, 12};
        int n = arr.length, count0fSwap = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count0fSwap++;
                }
            }
            if(count0fSwap == 0){
                break;
            }else{
                count0fSwap = 0;
            }
        }
        printArray(arr);
    }

    //Task 2
    public static void insertionSort(){
        int arr[] = {23,34, 5, 2 ,4,25, 66, 32, 87, 12};
        int n = arr.length;
//        for (int i = 1; i < n; ++i) {
//            int key = arr[i];
//            int j = i - 1;
//            while (j >= 0 && arr[j] > key) {
//                arr[j + 1] = arr[j];
//                j = j - 1;
//            }
//            arr[j + 1] = key;
//        }
        for (int i = n - 2; i >= 0; i--) {
            int key = arr[i];
            int j = i + 1;
            while (j < n && arr[j] < key) {
                arr[j - 1] = arr[j];
                j = j + 1;
            }
            arr[j - 1] = key;
        }
        printArray(arr);
    }

    //Task 3
    public static int[] SelectionSort(int arr[], int i){
        int n = arr.length;
        if(i == n){
            return arr;
        }else{
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            i++;
            SelectionSort(arr, i);
        }
        return arr;
    }

    public static void main(String[] args) {
        bubbleSort();
        //insertionSort();
//        int arr[] = {23,34, 5, 2 ,4,25, 66, 32, 87, 12};
//        arr = SelectionSort(arr, 0);
//        printArray(arr);

        Scanner sc = new Scanner(System.in);
        int arr[] = new int[20];

        for (int i = 0; i< 20; i++){
            System.out.print("Please enter " + i + 1 + " number: ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Positive numbers: ");
        for (int i = 0; i< 20; i++){
            if(arr[i] > 0){
                System.out.println(i);
            }
        }

        System.out.println("Negative numbers: ");
        for (int i = 0; i< 20; i++){
            if(arr[i] < 0){
                System.out.println(i);
            }
        }

        System.out.println("Odd numbers: ");
        for (int i = 0; i< 20; i++){
            if(arr[i] % 2 != 0){
                System.out.println(i);
            }
        }

        System.out.println("Even numbers: ");
        for (int i = 0; i< 20; i++){
            if(arr[i] % 2 == 0){
                System.out.println(i);
            }
        }

        System.out.println("Zeros: ");
        for (int i = 0; i< 20; i++){
            if(arr[i]== 0){
                System.out.println(i);
            }
        }
    }
}
