import java.util.List;
import java.util.Scanner;

public class ExpenseManager {
    private List<BudgetItem> budgetItems;

    public ExpenseManager(List<BudgetItem> budgetItems) {
        this.budgetItems = budgetItems;
    }

    public void addExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expense name: ");
        String name = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        Expense expense = new Expense(name, amount);
        budgetItems.add(expense);
        System.out.println("Expense added: " + name + " - $" + amount);
    }

    public void viewExpenses() {
        if (budgetItems.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("----- Expenses -----");
            for (BudgetItem item : budgetItems) {
                System.out.println(item.getName() + ": $" + item.calculateCost());
            }
        }
    }

    public void deleteExpense() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the expense to delete: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < budgetItems.size(); i++) {
            if (budgetItems.get(i).getName().equalsIgnoreCase(name)) {
                budgetItems.remove(i);
                System.out.println("Expense deleted: " + name);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense not found.");
        }
    }
}
