public final class Expense extends BudgetItem {
    private double amount;

    public Expense(String name, double amount) {
        super(name);
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
}