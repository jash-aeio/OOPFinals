public class Expense extends BudgetItem {
    private double amount;
    private String category;

    public Expense(String category, double amount) {
        super(category);
        this.category = category;
        this.amount = amount;
    }

    @Override
    public double calculateCost() {
        return amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
