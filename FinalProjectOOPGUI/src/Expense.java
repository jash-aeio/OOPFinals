// Expense.java

public class Expense extends BudgetItem {

    private String category; 
    private double amount; 

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String getName() {
        return category; 
    }

    @Override
    public double calculateCost() {
        return amount; 
    }

    public String getCategory() {
        return category; 
    }

    public double getAmount() {
        return amount; 
    }
}
