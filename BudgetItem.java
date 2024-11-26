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


    public String getCategory() {
        return null;
    }

    public abstract double calculateCost();
}

