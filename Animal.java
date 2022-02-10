package Lesson_6.online;

public class Animal {
    protected String name;
    protected int speed;

    public static int Animalcount = 0;


    public Animal (String name, int speed) {
        this.name = name;
        this.speed = speed;
        Animalcount++;

    }

    public void speak () {
        System.out.println(name + " Hello");
    }
    public void run () {
        System.out.println(name + " run with speed " + speed + " m");
    }
}
