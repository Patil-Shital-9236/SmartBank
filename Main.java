import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static BankAccount findAccount(String accountNumber, ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public static boolean accountExists(String accountNumber, ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }

    public static int getInt(Scanner sc, String messsage) {
        while (true) {
            try {
                System.out.print(messsage);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid Number! Try again.");
            }
        }
    }

    public static double getDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.println(message);
                return Double.parseDouble(sc.nextLine());

            } catch (Exception e) {
                System.out.println("Invalid amount! Enter numbers only..Try again.");
            }
        }
    }

    public static String getString(Scanner sc, String message) {
        System.out.println(message);
        return sc.nextLine();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        while (true) {

            System.out.println("\n******** SMART BANK MENU ********");
            System.out.println("1. Create Account ");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Show All Accounts");
            System.out.println("6. Show Transactions");
            System.out.println("7. Exit");

            int choice = getInt(sc, "Enter your choice:");

            switch (choice) {
                case 1:
                    System.out.println("Create Account selected..");

                    int type = getInt(sc, "Select Account type (1-Saving, 2-Current): ");

                    String accountNumber = getString(sc, "Enter Account Number : ");

                    if (accountExists(accountNumber, accounts)) {
                        System.out.println("Account Number already exists. Please use a different one.");
                        break;
                    }

                    String accountHolderName = getString(sc, "Enter Account Holder Name : ");
                    double balance = getDouble(sc, "Enter Initial Balance: ");

                    BankAccount account;

                    if (type == 1) {
                        account = new SavingsAccount(accountNumber, accountHolderName, balance);
                    } else {
                        account = new CurrentAccount(accountNumber, accountHolderName, balance);
                    }

                    accounts.add(account);
                    System.out.println("Account created Successfully..!");

                    break;

                case 2:
                    System.out.println("Deposit selected");

                    String depAccNo = getString(sc, "Enter Account Number to Deposit: ");

                    BankAccount depAcc = findAccount(depAccNo, accounts);

                    if (depAcc == null) {
                        System.out.println("Account not found!");
                    } else {
                        double amt = getDouble(sc, "Enter amount to Deposit! ");
                        depAcc.deposit(amt);
                        System.out.println("Deposit Successful..!");
                    }

                    break;

                case 3:
                    System.out.println("Withdraw selected");

                    String wAccNo = getString(sc, "Enter Account Number to Withdraw: ");

                    BankAccount wAcc = findAccount(wAccNo, accounts);

                    if (wAcc == null) {
                        System.out.println("Account not found..!");
                    } else {
                        double wAmt = getDouble(sc, "Enter amount to Withdraw: ");
                        wAcc.withdraw(wAmt);
                    }
                    break;

                case 4:
                    System.out.println("Check Balance selected");

                    String balAccNo = getString(sc, "Enter Account Number: ");

                    BankAccount balAcc = findAccount(balAccNo, accounts);

                    if (balAcc == null) {
                        System.out.println("Account not found..!");
                    } else {
                        balAcc.showAccountDetails();
                    }
                    break;

                case 5:
                    System.out.println("Show all Accounts selected");

                    System.out.println("\n************ All Accounts ************");

                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (BankAccount acc : accounts) {
                            System.out.println("************");
                            System.out.println("Account Number : " + acc.getAccountNumber());
                            System.out.println("Account Holder : " + acc.accountHolderName);
                            System.out.println("Balance        : " + acc.getBalance());
                            System.out.println("Account Type   : " + acc.getClass().getSimpleName());
                        }
                    }

                    break;

                case 6:

                    String tAcc = getString(sc, "Enter Account Number : ");

                    BankAccount ta = findAccount(tAcc, accounts);

                    if (ta == null) {
                        System.out.println("Account not found..!");
                    } else {
                        ta.showTransactions();
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using SmartBank..!");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        }

    }
}
