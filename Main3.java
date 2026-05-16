class BankAccount {
    protected double balance = 0.0;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance);
    }

    public double getBalance() { return balance; }
}

class OverdraftAccount extends BankAccount {
    @Override
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        System.out.println("Deposited: " + amount + " New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -500) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " New Balance: " + balance);
        } else {
            System.out.println("Withdrawal of: " + amount + " Failed: Overdraft limit has been exceeded");
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        OverdraftAccount acc = new OverdraftAccount();
        acc.deposit(1000);
        acc.withdraw(550);
        acc.withdraw(100);
    }
}