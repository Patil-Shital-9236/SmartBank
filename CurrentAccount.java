class CurrentAccount extends BankAccount {

    private double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        double maxAllowed = balance + overdraftLimit;

        if (amount <= maxAllowed) {
            balance -= amount;
            System.out.println("CurrentAccount: Withdrawn " + amount + " | New Balance : " + balance);
            addTransaction("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("CurrentAccount: Withdrawal exceeds overdraft limits!");
        }
    }

}
