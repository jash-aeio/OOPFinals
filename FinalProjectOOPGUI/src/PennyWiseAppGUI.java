
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PennyWiseAppGUI {

    private UserAuth userAuth;
    private PennyWise pennyWise;
    private PennyWish pennyWish;
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public PennyWiseAppGUI() {
        userAuth = new UserAuth();
        pennyWise = new PennyWise();
        pennyWish = new PennyWish();

        initialize();
    }

    private void initialize() {
        frame = new JFrame("Penny Wise App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create panels for different screens
        mainPanel.add(createWelcomePanel(), "Welcome");
        mainPanel.add(createMainMenuPanel(), "Main Menu");
        mainPanel.add(createPennyWisePanel(), "PennyWise Menu");
        mainPanel.add(createPennyWishPanel(), "PennyWish Menu");

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel label = new JLabel("Welcome to Penny Wise App!", JLabel.CENTER);
        JButton signUpButton = new JButton("Sign Up");
        JButton loginButton = new JButton("Log In");
        JButton exitButton = new JButton("Exit");

        signUpButton.addActionListener(e -> userAuth.signUp());
        loginButton.addActionListener(e -> {
            if (userAuth.login()) {
                cardLayout.show(mainPanel, "Main Menu");
            }
        });
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(label);
        panel.add(signUpButton);
        panel.add(loginButton);
        panel.add(exitButton);

        return panel;
    }

    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel label = new JLabel("Main Menu", JLabel.CENTER);
        JButton pennyWiseButton = new JButton("PennyWise (Expense Tracker)");
        JButton pennyWishButton = new JButton("PennyWish (Special Menu)");
        JButton signOutButton = new JButton("Sign Out");
        JButton exitButton = new JButton("Exit");

        pennyWiseButton.addActionListener(e -> {
            pennyWise.reset(); // Reset PennyWise before showing
            cardLayout.show(mainPanel, "PennyWise Menu");
        });
        pennyWishButton.addActionListener(e -> {
            pennyWish.reset(); // Reset PennyWish before showing
            cardLayout.show(mainPanel, "PennyWish Menu");
        });
        signOutButton.addActionListener(e -> cardLayout.show(mainPanel, "Welcome"));
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(label);
        panel.add(pennyWiseButton);
        panel.add(pennyWishButton);
        panel.add(signOutButton);
        panel.add(exitButton);

        return panel;
    }

    private JPanel createPennyWisePanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1));
        JLabel label = new JLabel("PennyWise Menu", JLabel.CENTER);
        JButton setBudgetButton = new JButton("Set Budget");
        JButton addExpenseButton = new JButton("Add Expense");
        JButton viewExpensesButton = new JButton("View Expenses");
        JButton generateSummaryButton = new JButton("Generate Summary");
        JButton backButton = new JButton("Back to Main Menu");

        setBudgetButton.addActionListener(e -> {
            pennyWise.setBudget();
            JOptionPane.showMessageDialog(panel, "Budget Set!");
        });
        addExpenseButton.addActionListener(e -> {
            pennyWise.addExpense();
            JOptionPane.showMessageDialog(panel, "Expense Added!");
        });
        viewExpensesButton.addActionListener(e -> {
            String expenses = pennyWise.viewExpenses();
            JOptionPane.showMessageDialog(panel, expenses);
        });
        generateSummaryButton.addActionListener(e -> {
            String summary = pennyWise.generateSummary();
            JOptionPane.showMessageDialog(panel, summary);
        });
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Main Menu"));

        panel.add(label);
        panel.add(setBudgetButton);
        panel.add(addExpenseButton);
        panel.add(viewExpensesButton);
        panel.add(generateSummaryButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPennyWishPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel label = new JLabel("PennyWish Menu", JLabel.CENTER);
        JButton addWishlistButton = new JButton("Add Wishlist Item");
        JButton viewWishlistButton = new JButton("View Wishlist");
        JButton generateSummaryButton = new JButton("Generate PennyWish Summary");
        JButton backButton = new JButton("Back to Main Menu");

        addWishlistButton.addActionListener(e -> {
            pennyWish.addWishlistItem();
            JOptionPane.showMessageDialog(panel, "Wishlist Item Added!");
        });
        viewWishlistButton.addActionListener(e -> {
            String wishlist = pennyWish.viewWishlist();
            JOptionPane.showMessageDialog(panel, wishlist);
        });
        generateSummaryButton.addActionListener(e -> {
            String summary = pennyWish.generatePennyWishSummary();
            JOptionPane.showMessageDialog(panel, summary);
        });
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Main Menu"));

        panel.add(label);
        panel.add(addWishlistButton);
        panel.add(viewWishlistButton);
        panel.add(generateSummaryButton);
        panel.add(backButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PennyWiseAppGUI::new);
    }
}
