import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String userChoice;
		ArrayList<User> users = new ArrayList<>();
		boolean exit = false;		
		
		while(!exit) {
			userChoice = takeInput(scanner);
			
			switch (userChoice) {
			case "1":
				// log in function
				String loginStatus = login(users, scanner);
				printing('*', 30); // print a line with 30 "*"

				if(loginStatus.equals("logged in")) { 			// checks if the user entered an existing username and then it checks if the 
					System.out.println("Logged in!"); // entered password is correct
				} else if(loginStatus.equals("canceled")){
					System.out.println("Operation was canceled");
				} else {
					System.out.println("No user found, please register first.");
				}
				printing('*', 30);
				break;
			case "2":
				// create user function
				printing('*', 30);
				System.out.println("Create User");
				printing('*', 30);
				createUser(users, scanner); //create a user and insert it into the 'users' arrayList
				printing('*', 30);
				break;
			case "3":
				//exit the program
				exit = true;
				break;
			default:
				//the user entered something different than the awaited input ("1", "2" or "3")
				System.out.println("Please enter a valid option");
				break;
			}
		}
		printing('*', 30);
		System.out.println("Have a nice day");
		scanner.close();
		
	}
	
	
	private static void printing(char symbol, int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}
	
	private static String takeInput(Scanner scanner) {
		System.out.println("1.Log In");
		System.out.println("2.Create User");
		System.out.println("3.Exit");
		System.out.print("Please choose an option (1, 2, or 3): ");
		
		return scanner.nextLine();
	}
	
	private static void createUser(ArrayList<User> users, Scanner scanner) {	
		System.out.print("Enter a new username: ");
		String username = scanner.nextLine();
		User newUser = new User();
		newUser.setName(username);
		
		System.out.print("Enter a password: ");
		String password = scanner.nextLine();
		newUser.setPassword(password);
		
		users.add(newUser);
		
		System.out.printf("User \"%s\" created!\n", newUser.getName());
		
	}
	
	private static String login(ArrayList<User> users, Scanner scanner) {
		System.out.print("Please enter your username: ");
		String username = scanner.nextLine();
		String responce = "";
		
		
		for(User user : users) {
			if(user.getName().equals(username)) {
				System.out.print("Please enter your password: ");
				while (true) {
					String password = scanner.nextLine();
					if(user.getPassword().equals(password)) {
						responce = "logged in";
						return responce;
					} else if(password.equals("cancel%%")){
						responce = "canceled";
						return responce;
					} 
					else {
						System.out.println("Wrong password,please try again.(type 'cancel%%' to cancel the operation)");
						System.out.print("Please enter your password: ");
					}
				}
			} else {
				responce = "does not exist";
			}
		}

		return responce;
	}
}
