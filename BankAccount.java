import java.util.ArrayList;
import java.util.Scanner;

abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited : " + amount);
            addTransaction("Deposited: " + amount + " | New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public void showAccountDetails() {
        System.out.println("\n------------ ACCOUNT SUMMARY ------------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Account Type   : " + this.getClass().getSimpleName());
        System.out.println("Balance        : " + balance);
        System.out.println("--------------------------------------------\n");
    }

    public void showTransactions() {
        System.out.println("\n ---------- TRANSACTION HISTORY ----------");

        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactions) {
                System.out.println(t);
            }
        }

        System.out.println("----------------------------------------------\n");
    }

    protected ArrayList<String> transactions = new ArrayList<>();

    public void addTransaction(String message) {
        transactions.add(message);
    }

}
