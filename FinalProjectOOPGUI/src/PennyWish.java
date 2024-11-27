import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PennyWish {
    private List<WishItem> wishList = new ArrayList<>();

    public void reset() {
        wishList.clear();
    }

    public void addWishlistItem() {
        String item = JOptionPane.showInputDialog("Enter wishlist item:");
        String priceStr = JOptionPane.showInputDialog("Enter price: PHP");
        try {
            double price = Double.parseDouble(priceStr);
            wishList.add(new WishItem(item, price));
            JOptionPane.showMessageDialog(null, "Item added to wishlist.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid price. Please enter a valid number.");
        }
    }

    public String viewWishlist() {
        if (wishList.isEmpty()) {
            return "Your wishlist is empty.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("+-----------------------------+\n");
            sb.append("|       Item       |   Price   |\n");
            sb.append("+-----------------------------+\n");
            for (WishItem item : wishList) {
                sb.append(String.format("| %-15s | %9.2f |\n", item.getName(), item.getPrice()));
            }
            sb.append("+-----------------------------+\n");
            return sb.toString();
        }
    }

    public String generatePennyWishSummary() {
        double totalCost = 0;
        for (WishItem item : wishList) {
            totalCost += item.getPrice();
        }

        String period = JOptionPane.showInputDialog("Select your savings period:\n[1] Daily\n[2] Weekly\n[3] Monthly");
        int periodChoice;
        try {
            periodChoice = Integer.parseInt(period);
        } catch (NumberFormatException e) {
            return "Invalid choice.";
        }

        String savingsStr = JOptionPane.showInputDialog("Enter your savings per period: PHP");
        double savingsPerPeriod;
        try {
            savingsPerPeriod = Double.parseDouble(savingsStr);
        } catch (NumberFormatException e) {
            return "Invalid savings amount.";
        }

        int periodsRequired = (int) Math.ceil(totalCost / savingsPerPeriod);
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- PennyWish Summary ---\n");
        sb.append(String.format("Total Wishlist Cost: PHP %.2f\n", totalCost));
        sb.append(String.format("You will need %d periods to complete your wishlist.\n", periodsRequired));
        return sb.toString();
    }
}