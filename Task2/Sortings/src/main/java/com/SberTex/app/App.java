package com.SberTex.app;

public class App {

    public static void main(String[] args) {
        sort sorting = new sort();
        System.out.println("It's sorting time");
        int len = 10;
        int[] arr = new int[len];

        sorting.fillArray(arr, len);
        sorting.printArray(arr, len);
        sorting.quickSort(arr, len);
        sorting.printArray(arr, len);
    }
}
