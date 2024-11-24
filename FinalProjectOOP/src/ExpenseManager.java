import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    private List<BudgetItem> budgetItems;

    public ExpenseManager(List<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }

    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();


        Expense expense = new Expense(category, amount);
        budgetItems.add(expense);
        System.out.println("Expense added: " + category + " - PHP " + amount);
    }

    public void viewExpenses() {
        if (budgetItems.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("----- Expenses -----");
            for (BudgetItem item : budgetItems) {
                Expense expense = (Expense) item;  // Cast to Expense
                System.out.println("Category: " + expense.getCategory() + ", Amount: PHP " + expense.getAmount()
                );
            }
        }
    }

    public void deleteExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the category of the expense to delete: ");
        String category = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < budgetItems.size(); i++) {
            if (budgetItems.get(i) instanceof Expense) {
                Expense expense = (Expense) budgetItems.get(i);
                if (expense.getCategory().equalsIgnoreCase(category)) {
                    budgetItems.remove(i);
                    System.out.println("Expense deleted: " + category);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Expense not found.");
        }
    }
}
