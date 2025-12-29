import java.util.Scanner;

public class AtmInterface {

    static Scanner input = new Scanner(System.in);

    public static int takeInput(int limit) {
        int choice;

        while (true) {
            try {
                choice = input.nextInt();
                if (choice >= 1 && choice <= limit) {
                    return choice;
                } else {
                    System.out.println("Choose a number between 1 and " + limit);
                }
            } catch (Exception e) {
                System.out.println("Enter a valid integer.");
                input.next();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("***** WELCOME TO ATM SYSTEM *****");
        System.out.println("1. Register");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");

        int choice = takeInput(2);

        if (choice == 1) {
            BankAccount account = new BankAccount();
            account.register();

            System.out.println("\n1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");

            int ch = takeInput(2);

            if (ch == 1 && account.login()) {

                System.out.println("\nWelcome " + account.getName());

                while (true) {
                    System.out.println("\n1. Withdraw");
                    System.out.println("2. Transfer");
                    System.out.println("3. Deposit");
                    System.out.println("4. Check Balance");
                    System.out.println("5. Transaction History");
                    System.out.println("6. Exit");
                    System.out.print("Enter choice: ");

                    int option = takeInput(6);

                    switch (option) {
                        case 1:
                            account.withdraw();
                            break;
                        case 2:
                            account.transfer();
                            break;
                        case 3:
                            account.deposit();
                            break;
                        case 4:
                            account.checkBalance();
                            break;
                        case 5:
                            account.showTransactionHistory();
                            break;
                        case 6:
                            System.out.println("Thank you! Have a nice day.");
                            System.exit(0);
                    }
                }
            }
        }

        System.out.println("Thank you! Have a nice day.");
    }
}