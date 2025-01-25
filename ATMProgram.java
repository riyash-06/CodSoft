import java.util.Scanner;

public class ATMProgram {

    // BankAccount class to store and manage the user's account balance
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful! New balance: " + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful! New balance: " + balance);
                return true;
            } else if (amount <= 0) {
                System.out.println("Withdrawal amount must be positive.");
            } else {
                System.out.println("Insufficient funds. Withdrawal failed.");
            }
            return false;
        }
    }

    // ATM class that provides the user interface and interaction with the bank account
    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void run() {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                displayMenu();
                System.out.print("Please select an option (1-4): ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        depositMoney(scanner);
                        break;
                    case 3:
                        withdrawMoney(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } while (choice != 4);

            scanner.close();
        }

        private void checkBalance() {
            System.out.println("Your current balance is: " + account.getBalance());
        }

        private void depositMoney(Scanner scanner) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        }

        private void withdrawMoney(Scanner scanner) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        // Create a bank account with an initial balance of 1000
        BankAccount myAccount = new BankAccount(1000);

        // Create an ATM instance linked to the bank account
        ATM atm = new ATM(myAccount);

        // Start the ATM simulation
        atm.run();
    }
}
