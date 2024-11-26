import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BudgetManager {
    private double totalBudget;
    private List<BudgetItem> budgetItems;

    public BudgetManager() {
        this.budgetItems = new ArrayList<>();
    }


    public void setBudget() {
        Budget budget = new Budget();
        this.totalBudget = budget.setAmount();
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

            try {
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
                        System.out.println("Returning to Main Menu...");
                        break;

                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        } while (manageChoice != 4);
    }


    public void viewBudget() {
        if (totalBudget > 0) {
            System.out.println("Your current budget is: PHP " + totalBudget);
            BudgetView budgetView = new BudgetView(totalBudget, budgetItems);
            budgetView.display();
        } else {
            System.out.println("Please set a budget first before viewing.");
        }
    }

    public void generateSummary() {
        if (totalBudget > 0) {
            System.out.println("Generating Budget Summary...");
            SummaryReport summaryReport = new SummaryReport(totalBudget, budgetItems);
            summaryReport.generate();
        } else {
            System.out.println("Please set a budget before generating a summary.");
        }
    }
}
