package Lesson_6.online;

public class Work6 {
    public static void main (String [] args) {
        Dog dog = new Dog ("Шарик",500, 10);
        Cat cat = new Cat ("Мотроскин", 200);
        Dog dog2 = new Dog("Чакки", 300, 5);


        dog.speak ();
        dog.run ();
        dog.swim ();
        dog2.speak ();
        dog2.run ();
        dog2.swim ();

        cat.speak ();
        cat.run ();
        System.out.println("Animal " + Animal.Animalcount + " Dog " + Dog.Dogcount + " Cat " + Cat.Catcount);
    }
}
