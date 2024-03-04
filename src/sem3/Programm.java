package sem3;

import java.util.ArrayList;

public class Programm {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Freelancer("Иван","Иванов",100));
        employees.add(new Worker("Сергей","Волков",85000));
        employees.add(new Freelancer("Марк","Тихонов",80));
        employees.add(new Freelancer("Игорь","Иванов",65));
        employees.add(new Worker("Антон","Сидоров",132000));
        employees.add(new Worker("Степан","Королев",105000));
        new PrintEmployee().PrintCollectionEmployees(employees);


    }
}
