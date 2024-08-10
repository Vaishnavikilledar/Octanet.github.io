import java.util.Scanner;

class Atm {
    private float balance;
    private final int PIN = 5674;
    private Scanner sc = new Scanner(System.in); // Single Scanner instance

    public void checkPin() {
        while (true) {
            System.out.println("Enter your pin:");
            int enteredPin = sc.nextInt();
            if (enteredPin == PIN) {
                menu();
                break; // Exit the loop once the PIN is correct
            } else {
                System.out.println("Enter a valid pin");
            }
        }
    }

    public void menu() {
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. EXIT");
            System.out.println("Enter your choice:");
            int opt = sc.nextInt();
            switch (opt) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    depositMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    sc.close(); // Close the Scanner
                    return; // Exit the program
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw:");
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Money Withdrawal Successful");
        }
    }

    public void depositMoney() {
        System.out.println("Enter the amount to deposit:");
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("Money Deposited Successfully");
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        Atm obj = new Atm();
        obj.checkPin();
    }
}