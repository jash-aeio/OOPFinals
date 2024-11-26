
import java.util.ArrayList;
import java.util.Scanner;

public class PennyWise {

    private ArrayList<BudgetItem> budgetItems = new ArrayList<>();
    private double totalBudget;

    // Main menu for PennyWise
    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- PennyWise Menu ---");
            System.out.println("[1] Set Budget\n[2] Add Expense\n[3] View Expenses\n[4] Generate Summary\n[5] Back to Main Menu");
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (choice) {
                case 1:
                    setBudget();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    viewExpenses();
                    break;
                case 4:
                    generateSummary();
                    break;
                case 5:
                    running = false;  // Return to main menu
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Set the total budget
    public void setBudget() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your total budget: PHP ");
        totalBudget = scanner.nextDouble();
        System.out.println("Budget set to PHP " + totalBudget);
    }

    // Add a new expense
    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: PHP ");
        double amount = scanner.nextDouble();
        budgetItems.add(new Expense(category, amount));
        System.out.println("Expense added.");
    }

    // View all expenses in a tabular format
    public void viewExpenses() {
        if (budgetItems.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("+------------------------------+");
            System.out.println("|       Category    |   Amount  |");
            System.out.println("+------------------------------+");
            for (BudgetItem item : budgetItems) {
                Expense expense = (Expense) item;
                System.out.printf("| %-15s | %9.2f |\n", expense.getCategory(), expense.getAmount());
            }
            System.out.println("+------------------------------+");
        }
    }

    public void generateSummary() {
        double totalExpenses = 0;
        for (BudgetItem item : budgetItems) {
            totalExpenses += item.calculateCost();
        }

        System.out.println("\n------ Budget Summary ------");
        System.out.printf("Total Budget: PHP %.2f\n", totalBudget);
        System.out.printf("Total Expenses: PHP %.2f\n", totalExpenses);
        System.out.printf("Remaining Budget: PHP %.2f\n", totalBudget - totalExpenses);

        System.out.println("\n--- Expense Breakdown ---");
        if (budgetItems.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (BudgetItem item : budgetItems) {
                System.out.printf("%-15s: PHP %.2f\n", item.getName(), item.calculateCost());
            }
        }
        System.out.println("----------------------------");
    }

}
