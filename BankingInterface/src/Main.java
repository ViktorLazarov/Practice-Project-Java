import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String userChoice;
		ArrayList<User> users = new ArrayList<>();
		boolean exit = false;		
		
		while(!exit) {
			printMenu();
			userChoice = scanner.nextLine();
			
			switch (userChoice) {
				case "1" -> { // log in function
                            String loginStatus = login(users, scanner);// checks if the user entered an existing username, and then it checks if the provided password is correct for the provided username
                            printing('*', 30); // print a line with 30 "*"
                            switch (loginStatus) {
                                case "logged in" -> System.out.println("Logged in!"); // the user logged in successfully
                                case "canceled" -> System.out.println("Operation was canceled"); // operation was canceled by the user
                                default -> System.out.println("No user found, please register first."); // there's no user with the provided username
                            }
                            printing('*', 30);
                        }
				case "2" -> {// create user function
                            printing('*', 30);
                            System.out.println("Create User");
                            printing('*', 30);
                            createUser(users, scanner); //create a user and insert it into the 'users' arrayList
                            printing('*', 30);
                        }
				case "3" -> exit = true; //exit the program
				default -> System.out.println("Please enter a valid option"); //the user entered something different from the awaited input ("1", "2" or "3")
			}
		}
		printing('*', 30);
		System.out.println("Have a nice day");
		scanner.close();
	}
	
	
	private static void printing(char symbol, int count) {
		// prints a line with the selected amount and type of symbol
		for (int i = 0; i < count; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}
	
	private static void printMenu() {
		// prints out the available options for the user to choose from
		System.out.println("1.Log In");
		System.out.println("2.Create User");
		System.out.println("3.Exit");
		System.out.print("Please choose an option (1, 2, or 3): ");
	}
	
	private static void createUser(List<User> users, Scanner scanner) {	
		User newUser = new User(); // create a new user object
		
		System.out.print("Enter a new username: ");
		String username = scanner.nextLine(); // read the username form the console
		while (userExists(users, username)) { // check if the selected username if not taken
			System.out.println("The user already exists. Please choose a different username.");
			System.out.print("Enter a new username: ");
			username = scanner.nextLine();
		}
		newUser.setName(username); // sets the name of the current user object to the provided username
		
		System.out.print("Enter a password: ");
		String password = scanner.nextLine(); // reads a password from the console
		newUser.setPassword(password); // sets the password of the current user object to the provided password
		
		users.add(newUser); // adds the created user object to the users list
		
		System.out.printf("User \"%s\" created!\n", newUser.getName()); // tells the user that a user with the provided username was created
	}
	
	private static String login(List<User> users, Scanner scanner) {
		System.out.print("Please enter your username: ");
		String username = scanner.nextLine();
		String response = "";
		
		for(User user : users) {  // go over all the objects in the list
			if(user.getName().equals(username)) { // checks if the name of the current object equals the username provided by the user
				System.out.print("Please enter your password: ");
				while (true) {
					String password = scanner.nextLine();
					if(user.getPassword().equals(password)) { // checks if the object's password match the password provided by the user
						response = "logged in";
						return response;
					} else if(password.equals("cancel%%")){ // the user chose to cancel the operation
						response = "canceled";
						return response;
					} 
					else {
						// offers an option to cancel the operation when the user enters 'cancel%%' instead of a password
						System.out.println("Wrong password,please try again.(type 'cancel%%' to cancel the operation)");
						System.out.print("Please enter your password: ");
					}
				}
			} else {
				// there's no user with the provided username
				response = "does not exist";
			}
		}

		return response;
	}

	public static boolean userExists(List<User> users, String username) {
        for (User user : users) {
            if (user.getName().equals(username)) { // checks if an object already exists with this username
                return true;
            }
        }
        return false;
    }
}
