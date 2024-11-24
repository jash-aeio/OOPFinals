import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetManager {
    private double totalBudget;
    private final List<BudgetItem> budgetItems;

    public BudgetManager() {
        this.budgetItems = new ArrayList<>();
    }

    public void setBudget() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your monthly budget: ");
        double budgetAmount = scanner.nextDouble();
        this.totalBudget = budgetAmount;
        System.out.println("Your budget has been set to: PHP" + totalBudget);
    }


    public double getBudget() {
        return this.totalBudget;
    }


    public void manageExpensesMenu() {
        Scanner scanner = new Scanner(System.in);
        ExpenseManager expenseManager = new ExpenseManager(budgetItems); 

        int manageChoice = 0;
        do {
            System.out.println("---- Manage Expenses ----");
            System.out.println("[1] Add Expense");
            System.out.println("[2] View Expenses");
            System.out.println("[3] Delete Expense");
            System.out.println("[4] Go Back to Main Menu");
            System.out.print("Enter Option: ");

            manageChoice = scanner.nextInt();

            switch (manageChoice) {
                case 1:
                    expenseManager.addExpense();
                    break;

                case 2:
                    expenseManager.viewExpenses();
                    break;

                case 3:
                    expenseManager.deleteExpense();
                    break;

                case 4:
                    return;


                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (manageChoice != 4);  // Repeat until user chooses to go back to the main menu
    }


    public void viewBudget() {
        if (totalBudget > 0) {
            System.out.println("\nYour current budget is: $" + totalBudget);

        } else {
            System.out.println("You need to set a budget first before viewing it.\n");
        }
    }


    public void generateSummary() {
        if (totalBudget > 0) {
            System.out.println("\nGenerating Budget Summary...\n");
            SummaryReport summaryReport = new SummaryReport(totalBudget, budgetItems);
            summaryReport.generate("Monthly");
        } else {
            System.out.println("Please set a budget before generating a summary.\n");
        }
    }

    // Check for overspending
    public void checkOverspending() {
        double totalSpent = 0;
        for (BudgetItem item : budgetItems) {
            totalSpent += ((Expense)item).getAmount();
        }

        if (totalSpent > totalBudget) {
            System.out.println("Warning: You have exceeded your budget by $" + (totalSpent - totalBudget));
        } else if (totalSpent > totalBudget * 0.9) {
            System.out.println("Warning: You are nearing your budget limit! You've spent $" + totalSpent);
        } else {
            System.out.println("You are within your budget. Total spent: $" + totalSpent);
        }
    }
}

