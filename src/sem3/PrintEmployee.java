package sem3;

import java.util.ArrayList;

public class PrintEmployee {
    public PrintEmployee(){

    }

    public void PrintCollectionEmployees(ArrayList<Employee> emp) {
        for (Employee employee: emp) {
            if (employee instanceof Freelancer) {
                System.out.println("Имя: " + employee.name + " " + "Фамилия: " + employee.surname + " " +
                        "Средняя зарплата:" + " " + employee.salaryCalculate());
            }
            if (employee instanceof Worker) {
                System.out.println("Имя: " + employee.name + " " + "Фамилия: " + employee.surname + " " +
                        "Средняя зарплата:" + " " + employee.salaryCalculate());
            }
        }
    }

}
