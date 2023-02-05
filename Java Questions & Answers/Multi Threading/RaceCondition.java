class Account {
    public int accountBalance = 0;

    public void credit(int amount) {
        for (int i=0;i<10000;i++) {
            accountBalance += amount;
        }
    }
    public  void debit(int amount) {
        for (int i=0;i<10000;i++) {
            accountBalance -= amount;
        }
    }
}
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread credit = new Thread(() -> {
            account.credit(100);
        });
        Thread debit = new Thread(() -> {
            account.debit(100);
        });

        credit.start();// After executing expecting 1000000 as account.accountBalance
        debit.start();// After executing expecting 0 as account.accountBalance
        credit.join();
        debit.join();
        System.out.println(account.accountBalance);
    }
}
/* Multiple threads are executing at the same time and accessing the same resource multiple times in this example.
First thread is accessing the account.balance, adding the value at the same time second thread is executing and using
the same variable and minuting the value. So the value is not being updated as expected.
This is called Race Condition*/