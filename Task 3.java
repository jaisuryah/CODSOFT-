//JAISURYAH KP
//BANK MANAGEMENT

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal");
        }
    }

    public double checkBalance() {
        System.out.println("Current Balance: $" + this.balance);
        return this.balance;
    }
}

class ATM {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initialize the account with $1000

        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: $");
                    amount = scanner.nextDouble();
                    userAccount.withdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    amount = scanner.nextDouble();
                    userAccount.deposit(amount);
                    break;
                case 3:
                    userAccount.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
