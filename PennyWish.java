import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PennyWish {
    private List<WishItem> wishList = new ArrayList<>();
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    public void addWishlistItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter wishlist item: ");
        String item = scanner.nextLine();
        System.out.print("Enter price: PHP ");
        double price = scanner.nextDouble();
        scanner.nextLine();  

        wishList.add(new WishItem(item, price));
        System.out.println("Item added to wishlist.");
    }

    public void viewWishlist() {
        if (wishList.isEmpty()) {
            System.out.println("Your wishlist is empty.");
        } else {
            System.out.println("+-----------------------------+");
            System.out.println("|       Item       |   Price   |");
            System.out.println("+-----------------------------+");
            for (WishItem item : wishList) {
                System.out.printf("| %-15s | %9.2f |\n", item.getName(), item.getPrice());
            }
            System.out.println("+-----------------------------+");
        }
    }

    public void generatePennyWishSummary() {
        double totalCost = 0;
        for (WishItem item : wishList) {
            totalCost += item.getPrice();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select your savings period:");
        System.out.println("[1] Daily");
        System.out.println("[2] Weekly");
        System.out.println("[3] Monthly");
        System.out.print("Enter your choice: ");
        int periodChoice = scanner.nextInt();

        String period = "";
        if (periodChoice == 1) {
            period = "Daily";
        } else if (periodChoice == 2) {
            period = "Weekly";
        } else if (periodChoice == 3) {
            period = "Monthly";
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter your savings per " + period + ": PHP ");
        double savingsPerPeriod = scanner.nextDouble();

        if (savingsPerPeriod <= 0) {
            System.out.println("Savings must be greater than zero.");
            return;
        }

        int periodsRequired = (int) Math.ceil(totalCost / savingsPerPeriod);
        displayCalendar(periodChoice, periodsRequired, savingsPerPeriod, totalCost);

        // Display summary
        System.out.println("\n--- PennyWish Summary ---");
        System.out.printf("Total Wishlist Cost: PHP %.2f\n", totalCost);
        System.out.printf("You will need %d %s to complete your wishlist.\n", periodsRequired, period.toLowerCase());
        System.out.println("-------------------------");
    }

    private void displayCalendar(int periodChoice, int periodsRequired, double savingsPerPeriod, double totalCost) {
        System.out.println("\n--- Calendar Progress ---");

        LocalDate today = LocalDate.now();
        int itemsPerRow;
        String periodUnit;
        if (periodChoice == 1) {
            itemsPerRow = 7;  
            periodUnit = "Day";
        } else if (periodChoice == 2) {
            itemsPerRow = 4;  
            periodUnit = "Week";
        } else {
            itemsPerRow = 12;  
            periodUnit = "Month";
        }

        int fullRows = periodsRequired / itemsPerRow;
        int remainingPeriods = periodsRequired % itemsPerRow;
        int totalPeriodsCovered = 0;

        LocalDate currentDate = today;

        for (int row = 1; row <= fullRows; row++) {
            System.out.print(periodUnit + " " + row + ": ");
            for (int col = 0; col < itemsPerRow; col++) {
                totalPeriodsCovered++;
                double currentSavings = totalPeriodsCovered * savingsPerPeriod;

                String dateDisplay = currentDate.format(dateFormatter);

                if (currentSavings <= totalCost) {
                    System.out.print("[X] " + dateDisplay + " ");
                } else {
                    System.out.print("[ ] " + dateDisplay + " ");
                }

                currentDate = getNextDate(periodChoice, currentDate);
            }
            System.out.println();
        }

        if (remainingPeriods > 0) {
            System.out.print(periodUnit + " " + (fullRows + 1) + ": ");
            for (int col = 0; col < remainingPeriods; col++) {
                totalPeriodsCovered++;
                double currentSavings = totalPeriodsCovered * savingsPerPeriod;

                String dateDisplay = currentDate.format(dateFormatter);

                if (currentSavings <= totalCost) {
                    System.out.print("[X] " + dateDisplay + " ");
                } else {
                    System.out.print("[ ] " + dateDisplay + " ");
                }

                currentDate = getNextDate(periodChoice, currentDate);
            }
            System.out.println();
        }

        System.out.println("--- End of Calendar ---");
    }

    private LocalDate getNextDate(int periodChoice, LocalDate currentDate) {
        if (periodChoice == 1) {
            return currentDate.plusDays(1);  
        } else if (periodChoice == 2) {
            return currentDate.plusWeeks(1); 
        } else {
            return currentDate.plusMonths(1);  
        }
    }
}
