import javax.swing.*;
import java.util.ArrayList;

public class PennyWise {
    private ArrayList<BudgetItem> budgetItems = new ArrayList<>();
    private double totalBudget;

    public void reset() {
        budgetItems.clear();
        totalBudget = 0;
    }

    public void setBudget() {
        String input = JOptionPane.showInputDialog("Enter your total budget: PHP");
        try {
            totalBudget = Double.parseDouble(input);
            JOptionPane.showMessageDialog(null, "Budget set to PHP " + totalBudget);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }

    public void addExpense() {
        String category = JOptionPane.showInputDialog("Enter expense category:");
        String amountStr = JOptionPane.showInputDialog("Enter amount: PHP");
        try {
            double amount = Double.parseDouble(amountStr);
            budgetItems.add(new Expense(category, amount));  
            JOptionPane.showMessageDialog(null, "Expense added.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number.");
        }
    }

    public String viewExpenses() {
        if (budgetItems.isEmpty()) {
            return "No expenses recorded yet.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("+------------------------------+\n");
            sb.append("|       Category    |   Amount  |\n");
            sb.append("+------------------------------+\n");
            for (BudgetItem item : budgetItems) {
                Expense expense = (Expense) item; 
                sb.append(String.format("| %-15s | %9.2f |\n", expense.getCategory(), expense.getAmount()));
            }
            sb.append("+------------------------------+\n");
            return sb.toString();
        }
    }

    public String generateSummary() {
        double totalExpenses = 0;
        for (BudgetItem item : budgetItems) {
            totalExpenses += item.calculateCost();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n------ Budget Summary ------\n");
        sb.append(String.format("Total Budget: PHP %.2f\n", totalBudget));
        sb.append(String.format("Total Expenses: PHP %.2f\n", totalExpenses));
        sb.append(String.format("Remaining Budget: PHP %.2f\n", totalBudget - totalExpenses));
        sb.append("\n--- Expense Breakdown ---\n");
        if (budgetItems.isEmpty()) {
            sb.append("No expenses recorded.\n");
        } else {
            for (BudgetItem item : budgetItems) {
                sb.append(String.format("%- 15s: PHP %.2f\n", item.getName(), item.calculateCost()));
            }
        }
        sb.append("----------------------------\n");
        return sb.toString();
    }
}