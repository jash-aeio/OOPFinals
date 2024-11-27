
import java.util.ArrayList;

public class BudgetManager {

    private ArrayList<BudgetItem> budgetItems;

    public BudgetManager() {
        budgetItems = new ArrayList<>();
    }

    public void addBudgetItem(BudgetItem item) {
        budgetItems.add(item);
    }

    public ArrayList<BudgetItem> getBudgetItems() {
        return budgetItems;
    }
}
