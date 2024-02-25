import java.util.HashMap;
import java.util.Map;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            recipient.deposit(amount);
            System.out.println("Transfer successful");
        } else {
            System.out.println("Insufficient balance for transfer");
        }
    }
}

class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, String accountHolderName) {
        if (!accounts.containsKey(accountNumber)) {
            Account account = new Account(accountNumber, accountHolderName);
            accounts.put(accountNumber, account);
            System.out.println("Account created successfully");
        } else {
            System.out.println("Account already exists");
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}

class UserInterface {
    private Bank bank;

    public UserInterface(Bank bank) {
        this.bank = bank;
    }

    public void displayMenu() {
        System.out.println("Banking System Menu");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                transfer();
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
        }
    }

    private void createAccount() {
        // Code for creating an account
    }

    private void deposit() {
        // Code for depositing funds
    }

    private void withdraw() {
        // Code for withdrawing funds
    }

    private void transfer() {
        // Code for transferring funds
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        UserInterface ui = new UserInterface(bank);

        while (true) {
            ui.displayMenu();
            // Get user choice and call processChoice method
        }
    }
}
