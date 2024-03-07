package sem4;

public class InsufficientFundsException extends Exception{
    double startingBalance;
    double money;
    public InsufficientFundsException(String s,double startingBalance, double money){
        super(s);
        this.money =money;
        this.startingBalance = startingBalance;

    }
}
