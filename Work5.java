package Lesson_4.online;

public class Work5 {
    public static void main (String [] args){
        Employees employees1 = new Employees("Robert Downey jr", "Actor","+1-777-777-77-77",55.555f, 56 );
        employees1.speak();
        Employees employees2 = new Employees("Joe Biden", "President", "+1-888-888-88-88", 66.666f, 79);
        employees2.speak();
        Employees employees3 = new Employees("Vladimir Vladimirovich Putin", "President", "+1-777-777-77-77", 999.999f, 69);
                employees3.speak();
        Employees employees4 = new Employees("Donald Trump", "President", "+1-666-666-66-66",1000000.999999f, 75);
        employees4.speak();
        Employees employees5 = new Employees("Alexey Anatolyevich Navalny", "future president", "+7-999-888-77-66", 77.77f, 45);

//        employees1.fullName = "Robert Downey jr";
//        employees1.position = "Actor" ;
//        employees1.telephone = "+1-777-777-77-77";
//        employees1.salary = 55.555f;
//        employees1.age = 56;
//
//        employees2.fullName = "Vladimir Vladimirovich Putin";
//        employees2.position = "President" ;
//        employees2.telephone = "8-999-123-12-12";
//        employees2.salary = 999.999f;
//        employees2.age = 69;

//        System.out.println("ФИО: " + employees1.fullName +
//                           "; Должность: " + employees1.position +
//                           "; Телефон: " + employees1.telephone +
//                            "; Зарплата: " + employees1.salary +
//                            "; Возраст: " + employees1.age);
//        System.out.println("ФИО: " + employees2.fullName +
//                "; Должность: " + employees2.position +
//                "; Телефон: " + employees2.telephone +
//                "; Зарплата: " + employees2.salary +
//                "; Возраст: " + employees2.age);
//        employees1.speak();
//        employees2.speak();

    }
}
