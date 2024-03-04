package com.company;

import java.util.Scanner;

class User {
    private String userID;
    private String userPIN;
    private double accountBalance;

    // Constructor
    public User(String userID, String userPIN, double accountBalance) {
        this.userID = userID;
        this.userPIN = userPIN;
        this.accountBalance = accountBalance;
    }

    // Getter methods
    public String getUserID() {
        return userID;
    }

    public String getUserPIN() {
        return userPIN;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    // Setter method for account balance
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}

class ATM {
    public void checkBalance(User user) {
        System.out.println("Your current balance is: $" + user.getAccountBalance());
    }

    public void withdrawMoney(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else if (amount > user.getAccountBalance()) {
            System.out.println("Insufficient funds!");
        } else {
            user.setAccountBalance(user.getAccountBalance() - amount);
            System.out.println("$" + amount + " withdrawn successfully. Your new balance is: $" + user.getAccountBalance());
        }
    }

    public void depositMoney(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            user.setAccountBalance(user.getAccountBalance() + amount);
            System.out.println("$" + amount + " deposited successfully. Your new balance is: $" + user.getAccountBalance());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        User user = new User("123456", "7890", 1000.0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM.");

        // User authentication
        System.out.println("Please enter your userID: ");
        String userID = scanner.nextLine();

        System.out.println("Please enter your PIN: ");
        String userPIN = scanner.nextLine();

        if (!userID.equals(user.getUserID()) || !userPIN.equals(user.getUserPIN())) {
            System.out.println("Invalid userID or PIN. Exiting...");
            return;
        }

        System.out.println("Login successful!");

        // ATM operations
        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance(user);
                    break;
                case 2:
                    System.out.println("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawMoney(user, withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.depositMoney(user, depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

