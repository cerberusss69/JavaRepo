package Lesson_4.online;

public class Employees {

   private String fullName;
   private String position;
   private String telephone;
   private float salary;
   private int age;


    public Employees (String fullName,
                      String position,
                      String telephone,
                      float salary,
                      int age) {
        this.fullName = fullName;
        this.position = position;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;

    }
    void speak (){
        System.out.println("Полное имя " + fullName + " Должность " + position + " Телефон " + telephone + " Зарплата " + salary + " Возраст " + age);
    }
}