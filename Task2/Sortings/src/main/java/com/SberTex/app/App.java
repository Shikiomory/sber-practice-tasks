package com.SberTex.app;

public class App {

    public void printArray(int[] arr, int len) {
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void fillArray(int[] arr, int len) {
        for(int i = 0; i < len; ++i) {
            arr[i] = (int)(Math.random() * 100) + 1;
        }
    }

    public static void main(String[] args) {
        BubbleSort bsort = new BubbleSort();
        QuickSort qsort = new QuickSort();

        System.out.println("It's sorting time");
        int len = 10;
        int[] arr = new int[len];

        fillArray(arr, len);
        printArray(arr, len);
        qsort.quickSort(arr, len);
        printArray(arr, len);

        fillArray(arr, len);
        printArray(arr, len);
        bsort.BubbleSort(arr, len);
        printArray(arr, len);
    }
}
