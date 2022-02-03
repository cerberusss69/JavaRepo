package Lesson_6.online;

public class Cat extends Animal{
    public static int Catcount = 0;

    public Cat (String name, int speed) {
        super(name, speed);
        Catcount++;
    }

}
