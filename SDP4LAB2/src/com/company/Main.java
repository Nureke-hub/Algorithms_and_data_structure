package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static void printArray(String arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void heapify(int arr[], int n, int i){
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public static void heapSort(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for (int i=n-1; i>=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }


    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }


    public static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    public static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }
    public static void radixSort(int arr[], int n) {
        int m = getMax(arr, n);
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    public static void shellSort(int arr[]) {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
        printArray(arr);
    }


//  TASK 3
    public static void bubbleSort(int arr[]){
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
    }

    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }

    public static int[] fillAnArray(int size){
        Random random = new Random();
        int arr[] = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = random.nextInt(10000000);
        }
        return arr;
    }

    public static void task3(){
        System.out.println("Array size  | Quick | Bubble | Merge | Heap | Radix ");

        for(int i = 60000; i < 360001; i += 60000){
            System.out.print(i + "          ");
            int arr[] = fillAnArray(i);
            int arrClone[] = arr.clone();

            long startTime = System.currentTimeMillis();
            quickSort(arrClone, 0, arrClone.length - 1);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.print(executionTime + "      ");
            arrClone = arr;

//            startTime = System.currentTimeMillis();
//            bubbleSort(arrClone);
//            endTime = System.currentTimeMillis();
//            executionTime = endTime - startTime;
//            System.out.print(executionTime + "      ");
//            arrClone = arr;

            startTime = System.currentTimeMillis();
            mergeSort(arrClone, 0, arrClone.length - 1);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.print(executionTime + "      ");
            arrClone = arr;

            startTime = System.currentTimeMillis();
            heapSort(arrClone);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.print(executionTime + "      ");
            arrClone = arr;

            startTime = System.currentTimeMillis();
            radixSort(arrClone, arrClone.length);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.print(executionTime + "      ");

            System.out.println();
        }
    }

//  TASK 2
    public static String[] Count2(String [] arr2, int len, int compsn){
        int []order = new int[27];
        String []result= new String[27];
        int temp = 0;
        for(int i =0; i < len; i++) {
            temp = (int) arr2[i].charAt(compsn) - 96;
            if (temp != -48 && temp != -64) {
                order[(int) arr2[i].charAt(compsn) - 96] += 1;
            }
            else {
             order[0] += 1;
            }
        }

        for(int i = 1; i < 27; i++){
            order[i] += order[i - 1];
        }

        for(int i =len - 1; i >= 0; i--){
            temp = (int) arr2[i].charAt(compsn) - 96;
            if(temp != -48 && temp != -64) {
                result[order[(int) arr2[i].charAt(compsn) - 96]] = arr2[i];
                order[(int) arr2[i].charAt(compsn) - 96] -= 1;
            }
            else {
                result[order[0]] = arr2[i];
                order[0] -= 1;
            }
        }

        for(int i = 1; i < len + 1; i++){
            arr2[i - 1] = result[i];
        }
        return arr2;
    }

    public static void Radix2(String [] arr){

        int len = arr.length;
        int max = arr[0].length();
        String array[] = arr.clone();

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].toLowerCase();
            if (array[i].length() > max)
                max = array[i].length();
        }

        int dif;
        for(int i = 0; i < array.length; i++){
            dif = max - array[i].length();
            array[i] = array[i] + new String(new char[dif]).replace("\0", "0");
            //System.out.println(array[i]);
        }


        for(int compsn = max - 1; compsn >= 0; compsn -= 1){
            array = Count2(array, len, compsn);
        }

        for(int i =0; i < array.length; i++){
            array[i] = array[i].replace("0", " ");
            array[i] = array[i].trim();
            array[i] = array[i].substring(0, 1).toUpperCase() + array[i].substring(1);
        }

        for(int i =0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }


    public static void main(String[] args) {
        int arr[] = {478, 123, 1433, 563, 62, 7, 65, 234, 89, 436, 56};
        String[] strings = {"Computer","Monitor", "Keyboard","Speaker","Mouse", "Java", "Python", "PHP", "Kotlin", "Swift", "Machine", "Learning", "Algorithm", "Data", "Structure", "Cheese", "DataBase"};
        int n = arr.length;

//        heapSort(arr);
//        quickSort(arr, 0, n-1);
//        radixSort(arr, n);
//        shellSort(arr);
//        Radix2(strings);
//        task3();

    }
}
