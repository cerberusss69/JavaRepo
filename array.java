package Lesson_3.array;

import java.util.Random;

public class array {

    public static void main(String[] args) {
        System.out.println("Задание1");
        replaceDigit();

        System.out.println("Задание2");
        empty();

        System.out.println("Задание3");
//        nArr3();

        System.out.println("Задание4");
        styleEasy(5, 5);

        System.out.println("Задание5");
        twoArgument(5,6);

        System.out.println("Задание6");
        minMax();
    }


    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// * С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void replaceDigit() {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            System.out.println(arr[i] + " | ");
        }
    }

    //    2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void empty() {
        String[] emArray = new String[100];
        for (int i = 0; i < emArray.length; i++) {
            emArray[i] = "|" + i;
        }
        for (int i = 0; i < emArray.length; i++) {
            System.out.print(emArray[i] + "\t");
        }
        System.out.println();
    }


    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
//    public static void nArr3() {
//        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] < 6) {
//                arr[i] * 2;
//                System.out.print(arr[i] + "|");
//            }
//            System.out.println();
//        }
//        for (int i = 0; i < arr.length; i++) {

//            System.out.print(arr[i] + "|");
//        }
//        System.out.println();



    //   4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
// * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
    public static void styleEasy(int height, int width) {
        String[][] easy = new String[height][width];

        for (int y = 0; y < easy.length; y++) {
            for (int x = 0; x < easy[y].length; x++) {
                easy[y][x] = "[" + y + ":" + x + "]";
            }
        }
        for (int y = 0; y < easy.length; y++) {
            for (int x = 0; x < easy[y].length; x++) {
                System.out.print(easy[y][x] + "\t");
            }
            System.out.println();
        }
    }

    //   5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
    public static void twoArgument(int len, int initialValue) {
        int[] two = new int [len];

        for (int i = 0; i < two.length; i++) {
            two[i] = initialValue;
            System.out.println(two[i] + "|");
        }
    }
//   6. Задать одномерный массив и найти в нем минимальный и максимальный значения элементов;
    public static void minMax() {
        int [] arr = new int[10];
        Random random = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(200);
            System.out.println(arr[i] + "|");
        }
        int  min = arr [0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];
            }
        }
        System.out.println("min" + min);

        int max = arr [5];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("max" + max);
    }
}
