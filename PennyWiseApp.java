
import java.util.Scanner;

public class PennyWiseApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserAuth userAuth = new UserAuth();  
        PennyWise pennyWise = new PennyWise();  
        PennyWish pennyWish = new PennyWish();  

        System.out.println("Welcome to PennyWise!");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("[1] Sign Up\n[2] Login\n[3] Exit");
            System.out.print("Enter option: ");
            int authChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (authChoice) {
                case 1:
                    userAuth.signUp();
                    break;
                case 2:
                    loggedIn = userAuth.login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;  
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        boolean running = true;
        while (running) {
            System.out.println("[1] PennyWise (Expense Tracker)\n[2] PennyWish (Wishlist)\n[3] Exit");
            System.out.print("Enter option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    pennyWise.mainMenu(); 
                    break;
                case 2:
                    pennyWishMenu(pennyWish);  
                    break;
                case 3:
                    running = false;  
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    public static void pennyWishMenu(PennyWish pennyWish) {
        Scanner scanner = new Scanner(System.in);
        boolean wishMenuRunning = true;

        while (wishMenuRunning) {
            System.out.println("[1] Add Wishlist Item\n[2] View Wishlist\n[3] Generate PennyWish Summary\n[4] Back to Main Menu");
            System.out.print("Enter option: ");
            int wishChoice = scanner.nextInt();
            scanner.nextLine(); 

            switch (wishChoice) {
                case 1:
                    pennyWish.addWishlistItem(); 
                    break;
                case 2:
                    pennyWish.viewWishlist();  
                    break;
                case 3:
                    pennyWish.generatePennyWishSummary();  
                    break;
                case 4:
                    wishMenuRunning = false; 
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
