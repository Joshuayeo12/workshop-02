package bankaccount.src;

public class Main {
    public static void main(String[] args) {
     BankAccount joshAccount = new BankAccount("Joshua", "93820841");
     
     joshAccount.deposit(1000);
     joshAccount.withdraw(400);

        joshAccount.printAccountDetails();

    }

    
}
