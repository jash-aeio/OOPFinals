import java.util.List;

public class BudgetView {
    private final double totalBudget;
    private final List<BudgetItem> budgetItems;

    public BudgetView(double totalBudget, List<BudgetItem> budgetItems) {
        this.totalBudget = totalBudget;
        this.budgetItems = budgetItems;
    }

    public void display() {
        System.out.println("Total Budget: " + totalBudget);
        System.out.println("Expenses Breakdown:");
        for (BudgetItem item : budgetItems) {
            System.out.println(item.getName() + ": " + ((Expense)item).getAmount());
        }
    }
}
