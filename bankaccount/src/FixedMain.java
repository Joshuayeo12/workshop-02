package bankaccount.src;

public class FixedMain {
    public static void main(String[] args) {
        // Create a FixedDepositAccount using the default interest and duration
        FixedDepositAccount fixedAcc = new FixedDepositAccount("Joshua", 1000f);

        // FixedDepositAccount fixedAcc = new FixedDepositAccount("Joshua", 1000f, 5.0f, 12);

        // Print account details, including interest and duration
        fixedAcc.printAccountDetails();
    }
    
}
