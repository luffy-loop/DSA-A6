
public class BankAcc {
    private String holderName;
    private long accountNumber;
    private double balance;

    BankAcc(String holderName, long accountNumber, double balance) {
        if (holderName == null || holderName.isBlank()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }

        if (accountNumber < 0) {
            throw new IllegalArgumentException("Account number cannot be negative");
        }

        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }

        this.holderName = holderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        balance -= amount;
    }

    double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAcc b = new BankAcc("K.Poojasri", 12345, 5000);

        b.deposit(1000);
        b.withdraw(500);

        System.out.println("Account Holder: " + b.holderName);
        System.out.println("Account Number: " + b.accountNumber);
        System.out.println("Balance: " + b.getBalance());
    }
}
