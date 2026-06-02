// This does NOT work for overdraft
class BrokenOverdraft {
    private BankAccount account;

    public BrokenOverdraft(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        double current = account.getBalance();
        if (current - amount >= -500) {
            account.withdraw(amount);  // parent's method prevents negative!
        }
    }
}

public class TestBroken {
    public static void main(String[] args) {
        BankAccount realAccount = new BankAccount();
        realAccount.deposit(100.0);

        BrokenOverdraft broken = new BrokenOverdraft(realAccount);

        broken.withdraw(200.0);

        System.out.println("------------------------------------");
        System.out.println("Expected Balance: -100.0");
        System.out.println("Actual Balance: " + realAccount.getBalance());
        System.out.println("------------------------------------");
        System.out.println("CONCLUSION: The balance is still 100 because the ");
        System.out.println("real BankAccount.withdraw method blocked the negative value!");
    }
}