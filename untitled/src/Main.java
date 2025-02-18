import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void task1() {
        System.out.println("Hello world!");
    }

    public static void task2() {
        System.out.println("Вывод резальутата деления с остатком a на b");
        int a = 21, b = 8;
        System.out.println(a % b);
    }

    public static void task3() {
        System.out.print("Проверка числа на палиндром\nВведите число: ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        int i = 0;
        int len = number.length();
        boolean pal = true;
        while (i < len /2 && pal) {
            if (number.charAt(i) != number.charAt(len - i - 1)) pal = false;
            ++i;
        }
        System.out.println("Число - " + number + (pal ? " " : " не ") + "палиндром");
    }

    public static void task4() {
        System.out.println("Вывод суммы всех цифр цисла");
        int n = 123, sum = 0;
        int n_copy = n;
        while (n_copy > 0) {
            sum += n_copy % 10;
            n_copy /= 10;
        }
        System.out.println("Сумма цифр числа - " + n + " = " + sum);
    }

    public static void task5() {
        System.out.print("Вычисление веса на луне\nВведите вес на земле: ");
        Scanner scanner = new Scanner(System.in);
        float weight_Earth, weight_Moon;
        weight_Earth = scanner.nextFloat();
        weight_Moon = weight_Earth * 0.17f;
        System.out.println("Вес на луне: " + weight_Moon);
    }

    public static void task6() {
        System.out.println("Проверка числа на простоту\nВведите число: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int i = 2;
        boolean prime = true;
        if (number == 1) prime = false;

        while ((i <= Math.sqrt(number) + 1) && prime) {
            if (number % i == 0) prime = false;
            ++i;
        }
        System.out.println("число - " + number + (prime ? " " : " не ") + "простое");
    }

    public static void task7() {
        System.out.println("Вывод n первых чисел фибоначи\nВведите n: ");
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int prev_number = 0;
        int number = 1;
        int FibonacсiNumber = number;
        for (int i = 0; i < n; ++i) {
            System.out.print(FibonacсiNumber + " ");
            FibonacсiNumber = prev_number + number;
            prev_number = number;
            number = FibonacсiNumber;
        }
        System.out.println();
    }

    public static void task8() {
        System.out.println("Угадывание загаданной буквы\nВведите свою букву: ");
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        char letter = (char)(random.nextInt(25) + 65);
        System.out.println(letter);
        boolean guess = false;
        char user_letter;
        while(!guess) {
            user_letter = scanner.next().charAt(0);
            if (letter == user_letter) {
                guess = true;
                System.out.println("Right");
            }
            else {
                System.out.println((user_letter < letter) ? "You’re too low" : "You're too high");
            }
        }
    }

    public static void task9() {
        System.out.println("Решение квадратного уравнения");
        double a, b, c;
        double d;
        double x1, x2;
        a = 2; b = 3; c = 1;
        d = b * b - 4 * a * c;
        if (d < 0) System.out.println("Корней нет");
        else if (d == 0) {
            x1 = -b / (2 * a);
            System.out.println("x1 = x2 = " + x1);
        }
        else {
            x1 = (-b + Math.sqrt(d))/(2*a);
            x2 = (-b - Math.sqrt(d))/(2*a);
            System.out.println("x1 = " + x1 + " x2 = " + x2);
        }
    }

    public static void task10() {
        System.out.println("Перевод из арабской системы исчисления в римскую");
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        System.out.println("Введите число из диапазона: [1, 100]");
        while (number <= 0 || number > 100) {
            number = scanner.nextInt();
            if (number <= 0 || number > 100) System.out.println("Введеное число не входит в диапазон [1, 100]");
        }
        int number_copy = number;
        String roman_number = "";
        String[] letter = {"I", "V", "X", "L", "C"};
        int i = 0;
        while (number_copy > 0) {
            int digit = number_copy % 10;
            if (digit <= 3) roman_number = letter[i].repeat(digit) + roman_number;
            else if (digit == 4) roman_number = letter[i] + letter[i + 1] + roman_number;
            else if (digit < 9) roman_number = letter[i + 1] + letter[i].repeat(digit - 5) + roman_number;
            else if (digit == 9) {
                roman_number = letter[i] + letter[i + 2] + roman_number;
            }
            number_copy /= 10;
            i += 2;
        }
        System.out.println(number + " - " + roman_number);
    }

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
    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("Для выхода введите 0");
        Scanner scanner = new Scanner(System.in);
        int task;
        while (!exit) {
            System.out.println("Выберите номер задания:");
            task = scanner.nextInt();
            switch (task) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
                case 3:
                    task3();
                    break;
                case 4:
                    task4();
                    break;
                case 5:
                    task5();
                    break;
                case 6:
                    task6();
                    break;
                case 7:
                    task7();
                    break;
                case 8:
                    task8();
                    break;
                case 9:
                    task9();
                    break;
                case 10:
                    task10();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
    }
}