class OverdraftAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = -500;

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) return;
        double newBalance = balance - amount;  
        if (newBalance >= OVERDRAFT_LIMIT) {
            balance = newBalance;
            System.out.println("Withdrew " + amount + ", new balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Deposited " + amount + ", new balance: " + balance);
    }
}

public class Main4 {
    public static void main(String[] args) {
        OverdraftAccount myAccount = new OverdraftAccount();

        myAccount.deposit(200.0);
        myAccount.withdraw(100.0);
        myAccount.withdraw(500.0);
        myAccount.withdraw(200.0);
    }
}