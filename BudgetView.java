import java.util.List;

public class BudgetView {
    private final double totalBudget;
    private final List<BudgetItem> budgetItems;

    public BudgetView(double totalBudget, List<BudgetItem> budgetItems) {
        this.totalBudget = totalBudget;
        this.budgetItems = budgetItems;
    }

    public void display() {
        System.out.println("Total Budget: $" + totalBudget);

        double totalSpent = 0;
        double remainingBudget = totalBudget;

        System.out.println("Category Breakdown:");
        if (budgetItems.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            for (BudgetItem item : budgetItems) {
                if (item instanceof Expense) {
                    Expense expense = (Expense) item;
                    System.out.println("Category: " + expense.getCategory() + ", Amount Spent: $" + expense.getAmount());
                    totalSpent += expense.getAmount();
                }
            }
        }

        remainingBudget -= totalSpent;


        System.out.println("Summary:");
        System.out.println("Total Spent: PHP" + totalSpent);
        System.out.println("Remaining Budget: PHP" + remainingBudget);


        if (totalSpent > totalBudget) {
            System.out.println("Warning: You have exceeded your budget by $" + (totalSpent - totalBudget));
        } else if (totalSpent > totalBudget * 0.9) {
            System.out.println("Warning: You are nearing your budget limit!");
        } else {
            System.out.println("You are within your budget.");
        }
    }
}
