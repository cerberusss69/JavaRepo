package Lesson_6.online;

public class Dog extends Animal{
    private int speedWater;
    public static int Dogcount = 0;


    public Dog (String name, int speed, int speedWater) {
        super(name, speed);
        this.speedWater = speedWater;
        Dogcount++;
    }
    public void swim () {
        System.out.println(name + " swim with speed " + speedWater + " m");
    }
}
