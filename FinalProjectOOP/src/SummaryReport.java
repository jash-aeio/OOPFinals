import java.util.List;

public class SummaryReport {
    private final double totalBudget;
    private final List<BudgetItem> budgetItems;

    public SummaryReport(double totalBudget, List<BudgetItem> budgetItems) {
        this.totalBudget = totalBudget;
        this.budgetItems = budgetItems;
    }

    public void generate(String timeframe) {
        double totalSpent = 0;
        for (BudgetItem item : budgetItems) {
            totalSpent += ((Expense)item).getAmount();
        }

        System.out.println("Summary Report (" + timeframe + ")");
        System.out.println("Total Budget: " + totalBudget);
        System.out.println("Total Spent: " + totalSpent);
        System.out.println("Remaining: " + (totalBudget - totalSpent));
    }
}
