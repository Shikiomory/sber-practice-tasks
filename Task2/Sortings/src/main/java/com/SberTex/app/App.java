package com.SberTex.app;

public class sortings {

    public static void BubbleSort(int[] arr, int len) {
        for (int j = 0; j < len - 1; ++j) {
            for (int i = 0; i < len - 1 - j; ++i) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }
    //Быстрая сортировка
    public static void quickSortCore(int[] arr, int low, int high) {
        int i, j;
        int pivot;
        while (low < high) {
            i = low;
            j = high;
            pivot = arr[(low + high) / 2];
            while (i <= j) {
                while (arr[i] < pivot) ++i;
                while (arr[j] > pivot) --j;
                if (i <= j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    ++i;
                    --j;
                }
            }
            if (i - low < high - j) {
                quickSortCore(arr, low, j);
                low = i;
            }
            else{
                quickSortCore(arr, i, high);
                high = j;
            }
        }
    }

    public static void quickSort(int[] arr, int len) {
        int low = 0;
        int high = len - 1;
        quickSortCore(arr, low, high);
    }

    public static void printArray(int[] arr, int len) {
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void fillArray(int[] arr, int len) {
        for(int i = 0; i < len; ++i) {
            arr[i] = (int)(Math.random() * 100) + 1;
        }
    }
    public static void examples() {
        System.out.println("It's sorting time");
        int len = 10;
        int[] arr = new int[len];
        sortings.fillArray(arr, len);
        sortings.printArray(arr, len);
        sortings.quickSort(arr, len);
        sortings.printArray(arr, len);
    }
}


public class App {
    public static void main(String[] args) {
        sortings.examples();
    }
}
