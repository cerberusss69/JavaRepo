package Lesson07.online;

import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 03.02.2022
 */

public class Lesson7 extends Object {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        String string1 = "Qwerty!";
//        String string2 = "Qwer";
//        string2 += "ty!";
//        String string3 = scanner.nextLine(); //Qwerty!
//        String string4 = "Qwerty!";
//
//        System.out.println("string1 > " + string1);
//        System.out.println("string2 > " + string2);
//        System.out.println("string3 > " + string3);
//        System.out.println("string4 > " + string4);
//        System.out.println("**************");
//        System.out.println("string1 = string2 > " + (string1 == string2));
//        System.out.println("string1 = string3 > " + (string1 == string3));
//        System.out.println("string1 = string4 > " + (string1 == string4));
//        System.out.println("**************");
//        System.out.println("string1 = string2 > " + (string1.equals(string2)));
//        System.out.println("string1 = string3 > " + (string1.equals(string3)));
//        System.out.println("string1 = string4 > " + (string1.equals(string4)));

        String stringTest = "Test";
        StringBuilder stringBuilder = new StringBuilder("Test");

        long start = System.nanoTime(); //Unix-time <> timestamp

        for (int i = 0; i < 60000; i++) {
            stringTest += i; //Test0123456789..59999
        }

        float finish = System.nanoTime() - start;

        System.out.println(stringTest);
        System.out.println("Test time string = " + finish * 0.000001f + " millisec");


        start = System.nanoTime(); //Unix-time <> timestamp

        for (int i = 0; i < 60000; i++) {
            stringBuilder.append(i); //Test0123456789..59999
        }

        finish = System.nanoTime() - start;

        System.out.println(stringBuilder.toString());
        System.out.println("Test time stringBuilder = " + finish * 0.000001f + " millisec");
        System.out.println(stringTest.equals(stringBuilder.toString()));

    }
}
