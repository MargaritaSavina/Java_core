package sem3;

public class Freelancer extends Employee {

    double rate = 1;

    public Freelancer(){
        super.name = name;
        super.surname = surname;
    }

    public  Freelancer(String name, String surname, double rate){
        this.name = name;
        this.surname = surname;
        this.rate = rate;
    }
     public double salaryCalculate(){
        return this.salary = 20.8 * 8 * this.rate;
     }
}
