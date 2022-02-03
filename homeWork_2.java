package Lesson_2.online;

import static java.awt.SystemColor.text;

public class homeWork_2 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        System.out.println(check(10, 5));
        System.out.println("Задание 2");
        wholeNumber(-5);
        System.out.println("Задание 3");
        System.out.println(viceVersa(-1));
        System.out.println("Задание 4");
        lineRepeat("буква");
        System.out.println("Задание 5");
        fourthYear(2024);


    }
//            1. Написать метод, принимающий на вход два целых числа и проверяющий,
// * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
// * в противном случае – false.

    public static boolean check(int valueA, int valueB) {
        return (valueA + valueB >= 10 && valueA + valueB <= 20);
    }

//       2. Написать метод, которому в качестве параметра передается целое число,
// * метод должен напечатать в консоль, положительное ли число передали или отрицательное.
// * Замечание: ноль считаем положительным числом.

    public static void wholeNumber(int value) {

        if (value >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }

//  3. Написать метод, которому в качестве параметра передается целое число.
//   * Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.

    public static boolean viceVersa(int a) {
        if (a < 0) return true;
        return false;
    }

//    4. Написать метод, которому в качестве аргументов передается строка и число,
//  * метод должен отпечатать в консоль указанную строку, указанное количество раз;

    public static void lineRepeat(String text) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(text + i);
        }
    }

//  5.* Написать метод, который определяет, является ли год високосным,
// * и возвращает boolean (високосный - true, не високосный - false).
// * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

    public static boolean fourthYear(int x) {

        if ((x % 4 == 0) || (!(x % 100 == 0) && (x % 400 == 0))) {
            System.out.println("Високосный");
        } else {System.out.println("Не високосный");
        }

        return false;
    }

    }


