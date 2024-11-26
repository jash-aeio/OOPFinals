import java.util.InputMismatchException;
import java.util.Scanner;

public class Budget {
    private double amount;


    public double setAmount() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter your weekly/monthly budget: ");
                amount = scanner.nextDouble();

                if (amount <= 0) {
                    System.out.println("Budget cannot be set to less than or equal to zero. Please try again.");
                } else {
                    validInput = true;
                    System.out.println("Your budget has been set to: PHP" + amount);
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.\n");
                scanner.nextLine();
            }
        }
        return amount;
    }

    public double getAmount() {
        return amount;
    }
}

