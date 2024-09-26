import java.util.Scanner;

public class JavaReviewAssignment{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean enterAnotherAccount = true;
        double totalDeposit = 0.0;

        while (enterAnotherAccount) {
            String accountNumber = getAccountNumber(scanner);
            String accountType = getAccountType(scanner);
            String customerName = getCustomerName(scanner);
            double accountBalance = getAccountBalance(scanner);

            double monthlyFee = calculateMonthlyFee(accountType, accountBalance);
            totalDeposit += accountBalance;

            displayAccountInformation(accountNumber, accountType, customerName, accountBalance, monthlyFee);

            System.out.print("Do you wish to enter information for another account? (Y/N): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("N")) {
                enterAnotherAccount = false;
            }
        }

        System.out.println("Total amount of money deposited in all accounts: $" + totalDeposit);
    }

    public static String getAccountNumber(Scanner scanner) {
        System.out.print("Please enter the Account Number: ");
        return scanner.next();
    }

    public static String getAccountType(Scanner scanner) {
        System.out.println("Checking\nSavings");
        System.out.print("Select an Account Type from the menu above: ");
        int choice = scanner.nextInt();

        while (choice != 1 && choice != 2) {
            System.out.println("Invalid menu option. Please try again.");
            System.out.print("Select an Account Type from the menu above: ");
            choice = scanner.nextInt();
        }

        return (choice == 1) ? "Checking" : "Savings";
    }

    public static String getCustomerName(Scanner scanner) {
        System.out.print("Please enter the Customer's Name: ");
        return scanner.next();
    }

    public static double getAccountBalance(Scanner scanner) {
        System.out.print("Please enter the Account Balance: ");
        double balance = scanner.nextDouble();

        while (balance < 0) {
            System.out.println("Invalid account balance. Please enter a non-negative value.");
            System.out.print("Please enter the Account Balance: ");
            balance = scanner.nextDouble();
        }

        return balance;
    }

    public static double calculateMonthlyFee(String accountType, double accountBalance) {
        if (accountType.equalsIgnoreCase("Checking")) {
            return accountBalance * 0.001;
        } else {
            return 0.0;
        }
    }

    public static void displayAccountInformation(String accountNumber, String accountType,
                                                 String customerName, double accountBalance, double monthlyFee) {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Customer Name: " + customerName);
        System.out.printf("Account Balance: $%.2f%n", accountBalance);
        System.out.printf("Monthly Fee: $%.2f%n", monthlyFee);
    }
}
