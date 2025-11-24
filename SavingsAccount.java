class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("SavingsAccount: Withdrawn " + amount);
            addTransaction("Withdrawn: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("SavingsAccount: Insufficient balance");
        }
    }

}