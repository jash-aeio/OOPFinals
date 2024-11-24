public abstract class BudgetItem {
    private String name;

    public BudgetItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calculateCost() {
        return 0.0; // Default implementation
    }
}

