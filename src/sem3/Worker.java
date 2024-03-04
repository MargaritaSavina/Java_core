package sem3;

public class Worker extends Employee{

    public Worker(){
        super.name = name;
        super.surname = surname;
        super.salary = salary;

    }

    public Worker(String name, String surname, double salary){
        this.name = name;
        this.surname = surname;
        this.salary = salary;

    }

    public double salaryCalculate(){
        return  this.salary;
    }
}
