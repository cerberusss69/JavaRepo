package Lesson7.online;

import java.util.Scanner;

public class Lesson7 extends Object { //ОбЪект имеет методы, он что то умеет
//всё в java является обЪектом

    private static Scanner scanner = new Scanner(System.in);

    public static void main (String[] args){
//       метод toString
//        Lesson7 lesson7 = new Lesson7();
//        System.out.println(lesson7);
//
//        int [] a = {1};
//        System.out.println(a);

        String string1 = "Qwerty";
        String string2 = "Qwer";
        string2 += "ty";
        String string3 = scanner.nextLine(); // "Qwerty"
        String string4 = "Qwerty";

        System.out.println("string1 > " + string1);
        System.out.println("string2 > " + string2);
        System.out.println("string3 > " + string3);
        System.out.println("string4 > " + string4);
//        сравниваем между собой эти строки
        System.out.println("**************");
        System.out.println("string1 = string2 " + (string1 == string2));
        System.out.println("string1 = string3 " + (string1 == string3));
        System.out.println("string1 = string4 " + (string1 == string4));

    }
}
