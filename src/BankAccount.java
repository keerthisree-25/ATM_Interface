import java.util.Scanner;

public class BankAccount {

    private String name;
    private String userName;
    private String password;
    private String accountNo;

    private float balance = 50000f;
    private int transactions = 0;
    private String transactionHistory = "";

    Scanner input = new Scanner(System.in);

    public void register() {
        System.out.print("Enter your Name: ");
        name = input.nextLine();

        System.out.print("Enter your Username: ");
        userName = input.nextLine();

        System.out.print("Enter your Password: ");
        password = input.nextLine();

        System.out.print("Enter your Account Number: ");
        accountNo = input.nextLine();

        System.out.println("Registration successful. Please login.");
    }

    public boolean login() {
        while (true) {
            System.out.print("Enter Username: ");
            String u = input.nextLine();

            if (u.equals(userName)) {
                System.out.print("Enter Password: ");
                String p = input.nextLine();

                if (p.equals(password)) {
                    System.out.println("Login Successful!");
                    return true;
                } else {
                    System.out.println("Incorrect Password.");
                }
            } else {
                System.out.println("Username not found.");
            }
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        float amount = input.nextFloat();

        if (amount <= balance) {
            balance -= amount;
            transactions++;
            transactionHistory += "Withdrawn: Rs." + amount + "\n";
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        float amount = input.nextFloat();

        if (amount <= 25000) {
            balance += amount;
            transactions++;
            transactionHistory += "Deposited: Rs." + amount + "\n";
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit limit exceeded (Max Rs.25000).");
        }
    }

    public void transfer() {
        input.nextLine(); // clear buffer
        System.out.print("Enter recipient name: ");
        String recipient = input.nextLine();

        System.out.print("Enter amount to transfer: ");
        float amount = input.nextFloat();

        if (amount <= balance && amount <= 25000) {
            balance -= amount;
            transactions++;
            transactionHistory += "Transferred Rs." + amount + " to " + recipient + "\n";
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed (Check balance or limit).");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public void showTransactionHistory() {
        if (transactions == 0) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:\n" + transactionHistory);
        }
    }

    public String getName() {
        return name;
    }
}