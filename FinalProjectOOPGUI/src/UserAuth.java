
import javax.swing.*;
import java.util.HashMap;

public class UserAuth {

    private HashMap<String, String> users;
    private final String userDataFile = "data/users.dat";

    public UserAuth() {
        LoadUser loadUser = new LoadUser(userDataFile);
        users = loadUser.load();
    }

    public void signUp() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (users.containsKey(username)) {
            JOptionPane.showMessageDialog(null, "Username already exists. Try a different username.");
        } else {
            users.put(username, password);
            SaveUser saveUser = new SaveUser(userDataFile);
            saveUser.save(users); 
            JOptionPane.showMessageDialog(null, "Signup successful.");
        }
    }

    public boolean login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (users.containsKey(username) && users.get(username).equals(password)) {
            JOptionPane.showMessageDialog(null, "Login successful.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
            return false;
        }
    }
}
