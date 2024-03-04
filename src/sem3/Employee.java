package sem3;

public abstract class Employee {
    protected String name = "Имя не указано";
    protected String surname = "Фамилия не указана";
    protected double salary = 10;

    public abstract double salaryCalculate();
}
