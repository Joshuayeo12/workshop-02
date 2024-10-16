package bankaccount.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String name;                 // The name of the account holder
    private String accountnumber;        // The unique account number
    protected float accountbalance;        // The current balance of the account
    private List<String> transactions;   // A list to store transaction history
    private boolean isaccountclose;      // A flag indicating if the account is closed
    private LocalDateTime accountcreation; // The date and time when the account was created

    // Constructor to initialize a new bank account with a name and account number
    public BankAccount(String name, String accountnumber) {
        this.name = name;
        this.accountnumber = accountnumber;
        this.accountbalance = 0.0f;          // Initial balance set to 0
        this.transactions = new ArrayList<>(); // Initialize the transaction list
        this.isaccountclose = false;         // Set account status to open
        this.accountcreation = LocalDateTime.now(); // Set the account creation timestamp
    }


    protected float getBalance(){
        return accountbalance;
    }

    //Deposit
    // Method to deposit an amount into the account
    public void deposit(float amount) {
        // Validate the deposit amount and account status
        if (amount <= 0 || isaccountclose) {
            throw new IllegalArgumentException("Must deposit a positive number");
        }
        accountbalance += amount; // Update the account balance
        String myStr = "%s $%.2f";
        String operation = String.format(myStr, "deposit", amount); // Format the transaction string
        transactions.add(operation); // Add the transaction to the history
        String depositoperation = accountcreation + " " + operation + " " + accountbalance; // Log transaction
    }
    //Withdraw
    // Method to withdraw an amount from the account
    public void withdraw(float amount) {
        // Validate the withdrawal amount and account status
        if (isaccountclose || amount > accountbalance || amount <= 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        accountbalance -= amount; // Deduct the amount from the balance
        String minus = "%s $%.2f";
        String minusoperation = String.format(minus, "withdraw", amount); // Format the transaction string
        transactions.add(minusoperation); // Add the transaction to the history
        String withdrawoperation = accountcreation + minusoperation + accountbalance; // Log transaction
    }

    // Method to print account details for the customer
    public void printAccountDetails() {
        System.out.println("Account Name: " + name);
        System.out.println("Account Number: " + accountnumber);
        System.out.println("Account Balance: $" + String.format("%.2f", accountbalance));
        System.out.println("Account Creation Date: " + accountcreation);

        // Printing the transaction history
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction); // Print each transaction
        }
    }
}
