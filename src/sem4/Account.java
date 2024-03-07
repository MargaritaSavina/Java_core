package sem4;

public class Account {
    int id;

    static int countID = 1000;

    double startingBalance;

    double deposit = 0;

    double withdrawal = 0;

    public  Account(double startingBalance) {
        if (startingBalance < 0) throw new IllegalArgumentException("Баланс не может быть отрицательным");
        else {
            this.startingBalance = startingBalance;
            id = countID;
            countID++;
        }
    }

    public  void makeDeposit(double deposit) {
        if (deposit < 0) throw new IllegalArgumentException("Депозит не может быть отрицательным");
        else this.deposit = this.deposit + deposit;
    }

    public  void withdrawMoney(double money) throws InsufficientFundsException{
        if (this.startingBalance < money)
        {
            throw new InsufficientFundsException("Недостаточно средств на счете. Текущий баланс: " + this.startingBalance,startingBalance,money);
        }
        else this.startingBalance = this.startingBalance - money;
    }

    public void printInfo(){
        System.out.println("ID: " + id);
        System.out.println("Всего средств на счете: " + this.startingBalance);
        System.out.println("Депозит: " + this.deposit);
        }

}
