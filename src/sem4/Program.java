package sem4;

//Создать программу управления банковским счетом (Account).
////Программа должна позволять пользователю вводить начальный баланс счета, сумму депозита
// и сумму снятия средств. При этом она должна обрабатывать следующие исключительные ситуации:
////Попытка создать счет с отрицательным начальным балансом должна вызывать исключение
// IllegalArgumentException с соответствующим сообщением.
//Попытка внести депозит с отрицательной суммой должна вызывать исключение
// IllegalArgumentException с соответствующим сообщением.
//Попытка снять средства, сумма которых превышает текущий баланс, должна вызывать
// исключение InsufficientFundsException с сообщением о недостаточных средствах и
// текущим балансом.
////Продемонстрируйте работу вашего приложения:
//Программа должна обрабатывать все исключения с помощью конструкции try-catch, выводя соответствующие сообщения об ошибках.

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        try {
            ArrayList<Account> accounts = new ArrayList<>();
            accounts.add(new Account(10000));
            accounts.add(new Account(49765));
            accounts.add(new Account(111432));
            accounts.add(new Account(1346));
            accounts.add(new Account(1556));

            for (Account acc : accounts) {
                acc.printInfo();
            }

            accounts.get(1).makeDeposit(12345);
            accounts.get(1).withdrawMoney(13399);
            accounts.get(1).printInfo();
            accounts.get(4).withdrawMoney(100000);
        } catch (InsufficientFundsException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }
}
