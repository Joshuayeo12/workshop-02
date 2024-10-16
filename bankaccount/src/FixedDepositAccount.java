package bankaccount.src;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FixedDepositAccount extends BankAccount {
    private float interest;
    private int duration;
    private boolean isInterestSet;
    private boolean isDurationSet;

    // int the values
    private static final float DEFAULT_INTEREST = 3.0f; // Default interest rate
    private static final int DEFAULT_DURATION = 6; // Default duration in months

    // Setting initial balance
    private void setInitialBalance(float initalbalance) {// initalbalance is new
        if (accountbalance == 0.0f) {// account balance from BankAccount file
            this.accountbalance = initalbalance;
        } else {
            throw new IllegalArgumentException("Balance cannot be changed once set");
        }

    }

    // Constructor 1: Takes only name and balance, and assigns default interest and
    // duration
    public FixedDepositAccount(String name, float balance) {
        super(name, ""); // Calls the parent class (BankAccount) constructor
        setInitialBalance(balance); // Sets the initial balance, which cannot be changed later
        this.interest = DEFAULT_INTEREST; // Uses default interest value (3.0%)
        this.duration = DEFAULT_DURATION; // Uses default duration value (6 months)
        this.isInterestSet = false; // Interest has not been changed explicitly
        this.isDurationSet = false; // Duration has not been changed explicitly
    }

    // Constructor 2: Takes name, balance, and interest; uses default duration
    public FixedDepositAccount(String name, float balance, float interest) {
        super(name, ""); // Calls the parent class constructor
        setInitialBalance(balance); // Sets the initial balance, which cannot be changed later
        this.interest = interest; // Sets the interest rate provided by the user
        this.duration = DEFAULT_DURATION; // Uses default duration value (6 months)
        this.isInterestSet = true; // Interest has been explicitly set
        this.isDurationSet = false; // Duration has not been changed explicitly
    }

    // Constructor 3: Takes name, balance, interest, and duration
    public FixedDepositAccount(String name, float balance, float interest, int duration) {
        super(name, ""); // Calls the parent class constructor
        setInitialBalance(balance); // Sets the initial balance, which cannot be changed later
        this.interest = interest; // Sets the interest rate provided by the user
        this.duration = duration; // Sets the duration provided by the user
        this.isInterestSet = true; // Interest has been explicitly set
        this.isDurationSet = true; // Duration has been explicitly set

    }

    //For withdraw
    @Override
    public void withdraw(float amount){
        System.out.println("no operation as withdrawals are not allowed");
    }

    //For deposit
    @Override
    public void deposit(float amount){
        System.out.println("no operation as deposits are not allowed");
    }

    //for getting balance
    @Override
    public float getBalance() {
        // Return the balance with interest applied
        return super.getBalance() + (super.getBalance() * interest / 100);
    }

 // Printing the account details including interest and duration
 @Override
 public void printAccountDetails() {
     super.printAccountDetails(); // Call the parent class method to print base details
     //Adding on stuff to what was in the BankAccount
     System.out.println("Interest Rate: " + interest + "%");
     System.out.println("Duration: " + duration + " months");
     System.out.println("Balance with Interest: $" + String.format("%.2f", getBalance()));
 }


}