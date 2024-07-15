/*
* Student name: Kate Shchepetova
* Course: ICS4U1
* Date: 2024-05-15
* Netflix Streaming Platform
*/
package Netflix;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class User {
   // File paths for user accounts and profiles
	public static boolean running;
	public static String prof;
	public static String acc;
	public static String pass;
	public static String date;
   private static final String FILE_PATH = "accounts.txt";
   private static final String PROFILE_PATH = "profiles.txt";
   private static final String[] ICONS = {"[■]", "[□]", "[▢]", "[▣]"};
   public User() {
   	 running = true;
   	 prof = "default";
   	 acc = "default";
   	 pass = "default";
   	 date = "05/15/2024";
   }
   // Main method to run the user interface
   public static boolean login() {
       Scanner input = new Scanner(System.in);
       try {
           checkAndCreateInitialUser(input);
       } catch (IOException e) {
           System.out.println("Error initializing user: " + e.getMessage());
       }
       while (running) {
           System.out.print("Enter 1 to login into an existing account or 2 to create a new account (0 to exit): ");
           String userChoice = input.next();
           if (userChoice.equals("1")) {
               handleLogin(input);
           } else if (userChoice.equals("2")) {
               handleAccountCreation(input);
           } else if (userChoice.equals("0")) {
               running = false;
               return true;
           } else {
               System.out.println("Invalid choice. Please enter 1, 2, or 0.");
           }
       }
       return false;
   }
   // Handles the login process for existing users
   // pre: Scanner input for user interaction
   // post: Prints success message if login is successful, prompts for profile selection
   private static void handleLogin(Scanner input) {
       // Login credentials input
       System.out.print("\nEnter login: ");
       String login = input.next();
       System.out.print("Enter password: ");
       String password = input.next();
       try {
           if (login(login, password)) {
               System.out.println("\nSuccessful login!\n");
               acc = login;
               pass = password;
               selectProfile(login, input);
           } else {
               System.out.println("Login failed. Try again or type 'exit' to return.");
               if (input.next().equalsIgnoreCase("exit")) {
                   return;
               }
           }
       } catch (IOException e) {
           System.out.println("Error accessing account data: " + e.getMessage());
       }
   }
   // Handles the creation of a new user account
   // pre: Scanner input for user interaction
   // post: Creates a new user account and prompts for profile setup
   private static void handleAccountCreation(Scanner input) {
       // New account creation process
       System.out.print("\nEnter desired login: ");
       String newLogin = input.next();
       try {
           if (accountExists(newLogin)) {
               System.out.println("Login already exists. Please try a different login.");
           } else {
               System.out.print("Enter desired password: ");
               String newPassword = input.next();
               int accountPlan = chooseSubscriptionPlan(input);
               createAccount(newLogin, newPassword, accountPlan);
               setupProfiles(newLogin, accountPlan, input);
               System.out.println("\nAccount created successfully.\n");
           }
       } catch (IOException e) {
           System.out.println("Error creating account: " + e.getMessage());
       }
   }
   // Allows the user to select a subscription plan
   // pre: Scanner input for user interaction
   // post: Returns the selected subscription plan number
   private static int chooseSubscriptionPlan(Scanner input) {
       // Subscription plan selection process
       System.out.println("\nChoose a subscription plan:\n");
       System.out.println("1. Premium (up to 5 devices)");
       System.out.println("2. Gold (up to 3 devices)");
       System.out.println("3. Standard (1 device)");
       System.out.print("\nEnter the number corresponding to the subscription plan: ");
       int planNumber;
       do {
           planNumber = input.nextInt();
           if (planNumber < 1 || planNumber > 3) {
               System.out.print("Invalid input. Please enter a number between 1 and 3: ");
           }
       } while (planNumber < 1 || planNumber > 3);
       return planNumber;
   }
   // Sets up profiles for a new user account
   // pre: String login, int accountPlan, Scanner input for user interaction
   // post: Creates profiles based on the subscription plan and saves them to the profiles file
   private static void setupProfiles(String login, int accountPlan, Scanner input) throws IOException {
       // Profile setup process
       int profilesCount = (accountPlan == 1 ? 5 : (accountPlan == 2 ? 3 : 1));
       Random random = new Random();
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROFILE_PATH, true))) {
           for (int i = 1; i <= profilesCount; i++) {
               String icon = ICONS[random.nextInt(ICONS.length)];
               System.out.print("\nEnter profile name for Profile " + i + ": ");
               String profileName = input.next();
               System.out.println("\n\n1. Action & Adventure"
               		+ "\n2. Anime"
               		+ "\n3. Children & Family"
               		+ "\n4. Classic"
               		+ "\n5. Comedies"
               		+ "\n6. Documentaries"
               		+ "\n7. Dramas"
               		+ "\n8. Horror"
               		+ "\n9. Music (1701)"
               		+ "\n10. Romantic"
               		+ "\n11. Sci-fi & Fantasy"
               		+ "\n12. Sports (4370)"
               		+ "\n13. Thrillers (8933)"
               		+ "\n14. TV Shows (83)\n");
               System.out.print("Enter the number of favorite genre for Profile " + i + ": ");
               String genre = input.next();
               while(!(genre.equals("1") || genre.equals("2") || genre.equals("3") || genre.equals("4") || genre.equals("5") || genre.equals("6") || genre.equals("7") || genre.equals("8") || genre.equals("9") || genre.equals("10") || genre.equals("11") || genre.equals("12") || genre.equals("13") || genre.equals("14"))) {
               	System.out.print("\nError. Enter the number of favorite genre for Profile " + i + ": ");
                   genre = input.next();
               }
               writer.write(String.format("%s,%s,%s,%s\n", login, profileName, genre, icon));
           }
       }
   }
   // Allows the user to select a profile for viewing
   // pre: String login, Scanner input for user interaction
   // post: Displays available profiles, prompts for profile selection
   private static void selectProfile(String login, Scanner input) throws IOException {
       // Profile selection process
       boolean selecting = true;
       while (selecting) {
           System.out.println("\nAvailable profiles:\n");
           try (BufferedReader reader = new BufferedReader(new FileReader(PROFILE_PATH))) {
               String line;
               boolean foundProfiles = false;
               while ((line = reader.readLine()) != null) {
                   String[] data = line.split(",");
                   if (data[0].equals(login)) {
                       System.out.println(data[3] + " " + data[1] + "   Favourite genre: " + data[2]); // Display icon, profile name, and genre
                       foundProfiles = true;
                   }
               }
               if (!foundProfiles) {
                   System.out.println("No profiles found for this account.");
                   return;
               }
           }
           System.out.print("\nEnter profile name to continue or type 'exit' to quit: ");
           String profileName = input.next();
           if (profileName.equalsIgnoreCase("exit")) {
               selecting = false;
               continue;
           }
           if (!profileExists(login, profileName)) {
               System.out.println("Profile does not exist. Please try again.");
           } else {
               System.out.println("\nProfile " + profileName + " selected successfully.\n");
               selecting = false;  // Exit the loop if the profile exists and is selected
               running = false;
               prof = profileName;
           }
       }
   }
   // Checks if a profile exists for a given login
   // pre: String login, String profileName
   // post: Returns true if the profile exists, false otherwise
   private static boolean profileExists(String login, String profileName) throws IOException {
       // Profile existence check process
       try (BufferedReader reader = new BufferedReader(new FileReader(PROFILE_PATH))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] data = line.split(",");
               if (data[0].equals(login) && data[1].equals(profileName)) {
                   return true;  // Profile exists under the login
               }
           }
       }
       return false;  // Profile does not exist
   }
   // Checks if an initial user account exists; if not, creates one
   // pre: Scanner input for user interaction
   // post: Creates an initial user account if none exists
   private static void checkAndCreateInitialUser(Scanner input) throws IOException {
       // Initial user account creation process
       File file = new File(FILE_PATH);
       if (!file.exists() || file.length() == 0) {
           createAccount("login1", "password", 2); // Initial user with login1 and password, plan 2
           // Manually setting up the four profiles for login1 with predefined icons
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(PROFILE_PATH, true))) {
               writer.write("login1,Profile1,Thriller,[■]\n");
               writer.write("login1,Profile2,Romantic,[□]\n");
               writer.write("login1,Profile3,Sports,[▢]\n");
               writer.write("login1,Profile4,Comedy,[▣]\n");
           }
       }
   }
   // Checks if an account exists for a given login
   // pre: String login
   // post: Returns true if the account exists, false otherwise
   public static boolean accountExists(String login) throws IOException {
       // Account existence check process
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
           String line;
           while ((line = reader.readLine()) != null) {
               if (line.startsWith(login + ",")) {
                   return true; // Login already exists
               }
           }
       }
       return false;
   }
   // Validates login credentials
   // pre: String login, String password
   // post: Returns true if login is successful, false otherwise
   private static boolean login(String login, String password) throws IOException {
       // Login validation process
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
           String line;
           while ((line = reader.readLine()) != null) {
               String[] data = line.split(",");
               if (data[0].equals(login) && data[1].equals(password)) {
                   return true;
               }
           }
       }
       return false;
   }
   // Creates a new user account
   // pre: String login, String password, int accountPlan
   // post: Creates a new account with the provided login, password, and subscription plan
   public static void createAccount(String login, String password, int accountPlan) throws IOException {
       // Account creation process
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
           writer.write(String.format("%s,%s,%d\n", login, password, accountPlan)); // Write the new account
       }
   }
  
   // Handles the change of user settings such as username, password, or profile
   // pre: None
   // post: Depending on user input, changes the username, password, or profile name
   public static void changeSettings() {
       System.out.println("\n1. Change username\n2. Change password\n3. Change profile name\n4. Change date\n");
       Scanner input = new Scanner(System.in);
       System.out.print("Enter the number from 1 to 4: ");
       String choice = input.next();
       switch (choice) {
           case "1":
               System.out.print("Enter new username: ");
               String newUsername = input.next();
               try {
                   changeUsername(acc, newUsername);
                   System.out.println("Username changed successfully!");
               } catch (IOException e) {
                   System.out.println("Error changing username: " + e.getMessage());
               }
               break;
           case "4":
           	System.out.println("Current date is " + date);
           	System.out.print("Enter month (xx): ");
           	String month = input.next();
           	System.out.print("Enter day (xx): ");
           	String day = input.next();
           	System.out.print("Enter year (xxxx): ");
           	String year = input.next();
           	date = month + "/" + day + "/" + year;
           	break;
           case "2":
               System.out.print("Enter new password: ");
               String newPassword = input.next();
               try {
                   changePassword(acc, newPassword);
                   System.out.println("Password changed successfully!");
               } catch (IOException e) {
                   System.out.println("Error changing password: " + e.getMessage());
               }
               break;
           case "3":
               System.out.print("Enter new profile name: ");
               String newProfileName = input.next();
               try {
                   changeProfileName(acc, prof, newProfileName);
                   System.out.println("Profile name changed successfully!");
               } catch (IOException e) {
                   System.out.println("Error changing profile name: " + e.getMessage());
               }
               break;
           default:
               System.out.println("Invalid choice.");
       }
   }
   // Changes the username in the accounts file and updates the current username
   // pre: String oldUsername, String newUsername
   // post: Modifies the accounts file to change the username and updates the current username
   private static void changeUsername(String oldUsername, String newUsername) throws IOException {
       File file = new File(FILE_PATH);
       File profileFile = new File(PROFILE_PATH);
       if (!file.exists()) {
           throw new IOException("Accounts file not found.");
       }
       BufferedReader reader = new BufferedReader(new FileReader(file));
       String line;
       StringBuilder content = new StringBuilder();
       while ((line = reader.readLine()) != null) {
           if (line.startsWith(oldUsername + ",")) {
               line = newUsername + line.substring(oldUsername.length());
           }
           content.append(line).append("\n");
       }
       reader.close();
       BufferedWriter writer = new BufferedWriter(new FileWriter(file));
       writer.write(content.toString());
       writer.close();
       acc = newUsername; // Update current username
       // Update username in profiles.txt
       if (profileFile.exists()) {
           BufferedReader profileReader = new BufferedReader(new FileReader(profileFile));
           StringBuilder profileContent = new StringBuilder();
           while ((line = profileReader.readLine()) != null) {
               String[] parts = line.split(",");
               if (parts[0].equals(oldUsername)) {
                   parts[0] = newUsername;
                   line = String.join(",", parts);
               }
               profileContent.append(line).append("\n");
           }
           profileReader.close();
           BufferedWriter profileWriter = new BufferedWriter(new FileWriter(profileFile));
           profileWriter.write(profileContent.toString());
           profileWriter.close();
       }
   }
   // Changes the password in the accounts file and updates the current password
   // pre: String username, String newPassword
   // post: Modifies the accounts file to change the password and updates the current password
   private static void changePassword(String username, String newPassword) throws IOException {
       File file = new File(FILE_PATH);
       if (!file.exists()) {
           throw new IOException("Accounts file not found.");
       }
       BufferedReader reader = new BufferedReader(new FileReader(file));
       String line;
       StringBuilder content = new StringBuilder();
       while ((line = reader.readLine()) != null) {
           if (line.startsWith(username + ",")) {
               String[] parts = line.split(",");
               line = parts[0] + "," + newPassword + "," + parts[2]; // Update password
           }
           content.append(line).append("\n");
       }
       reader.close();
       BufferedWriter writer = new BufferedWriter(new FileWriter(file));
       writer.write(content.toString());
       writer.close();
       pass = newPassword; // Update current password
   }
// Cancels the subscription for the current user
// pre: None
// post: Removes the user's account from accounts.txt and profiles.txt, displays a cancellation success message with the date
public static void cancelSubscription() {
    Scanner input = new Scanner(System.in);
    System.out.print("Are you sure you want to cancel your subscription? (yes/no): ");
    String confirmation = input.next();
    
    if (confirmation.equalsIgnoreCase("yes")) {
        try {
            removeAccountFromFile(acc);
            removeProfilesFromFile(acc);
            System.out.println("Your subscription has been successfully cancelled on " + date + ".");
            System.out.println("Logging out...");
        } catch (IOException e) {
            System.out.println("Error cancelling subscription: " + e.getMessage());
        }
    } else {
        System.out.println("Cancellation aborted.");
    }
}


// Removes the user's account from accounts.txt
// pre: String username
// post: Modifies the accounts file to remove the user's account
private static void removeAccountFromFile(String username) throws IOException {
    File file = new File(FILE_PATH);
    if (!file.exists()) {
        throw new IOException("Accounts file not found.");
    }
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    StringBuilder content = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        if (!line.startsWith(username + ",")) {
            content.append(line).append("\n");
        }
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write(content.toString());
    writer.close();
}


// Removes the user's profiles from profiles.txt
// pre: String username
// post: Modifies the profiles file to remove all profiles associated with the user's account
private static void removeProfilesFromFile(String username) throws IOException {
    File file = new File(PROFILE_PATH);
    if (!file.exists()) {
        throw new IOException("Profiles file not found.");
    }
    BufferedReader reader = new BufferedReader(new FileReader(file));
    String line;
    StringBuilder content = new StringBuilder();
    while ((line = reader.readLine()) != null) {
        String[] data = line.split(",");
        if (!data[0].equals(username)) {
            content.append(line).append("\n");
        }
    }
    reader.close();
    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
    writer.write(content.toString());
    writer.close();
}
   // Changes the profile name in the profiles file and updates the current profile name
   // pre: String username, String oldProfileName, String newProfileName
   // post: Modifies the profiles file to change the profile name and updates the current profile name
   private static void changeProfileName(String username, String oldProfileName, String newProfileName) throws IOException {
       File file = new File(PROFILE_PATH);
       if (!file.exists()) {
           throw new IOException("Profiles file not found.");
       }
       BufferedReader reader = new BufferedReader(new FileReader(file));
       String line;
       StringBuilder content = new StringBuilder();
       while ((line = reader.readLine()) != null) {
           if (line.startsWith(username + "," + oldProfileName + ",")) {
               String[] parts = line.split(",");
               line = parts[0] + "," + newProfileName + "," + parts[2] + "," + parts[3]; // Update profile name
           }
           content.append(line).append("\n");
       }
       reader.close();
       BufferedWriter writer = new BufferedWriter(new FileWriter(file));
       writer.write(content.toString());
       writer.close();
       prof = newProfileName; // Update current profile name
   }
}



