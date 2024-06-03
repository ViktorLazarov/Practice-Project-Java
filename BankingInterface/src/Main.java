import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String userChoice = "";
		ArrayList<ArrayList<String>> users = new ArrayList<ArrayList<String>>();
		boolean exit = false;
		
//		User user1 = new User("viktor1", "lazarov1", 100);
//		
//		System.out.println(user1.getName());
//		
//		user1.setName("viktor");
//		
//		System.out.println(user1.getName());
		
		
		while(!exit) {
			userChoice = takeInput(scanner);
			
			while(!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3")) {
				
				System.out.println("Please enter a valid option");
				userChoice = takeInput(scanner);
			}
			
			switch (userChoice) {
			case "1":
				// log in function
				printing('*', 30);
				if(login(users, scanner)) {
					System.out.println("Logged in!");
				}
				printing('*', 30);
				break;
			case "2":
				// create user function
				printing('*', 30);
				System.out.println("Create User");
				printing('*', 30);
				createUser(users, scanner);
				printing('*', 30);
				break;
			case "3":
				exit = true;
				break;
			}
		}
		printing('*', 30);
		System.out.println("Have a nice day");
		
		
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
	
	private static void createUser(ArrayList<ArrayList<String>> users, Scanner scanner) {
		ArrayList<String> newUser = new ArrayList<String>();
	
		System.out.print("Enter a new username: ");
		String username = scanner.nextLine();	
		newUser.add(username);
		
		System.out.print("Enter a password: ");
		String password = scanner.nextLine();
		newUser.add(password);
		
		users.add(newUser);
		
		System.out.printf("User \"%s\" created!\n", username);
		
	}
	
	private static boolean login(ArrayList<ArrayList<String>> users, Scanner scanner) {
		System.out.print("Please enter your username: ");
		String username = scanner.nextLine();
		
		
		for(ArrayList<String> user : users) {
			if(user.contains(username)) {
				System.out.print("Please enter your password: ");
				String password = scanner.nextLine();
				if(user.contains(password)) {
					return true;
					
				} else {
					System.out.println("Wrong Password!");
				}
			}else {
				System.out.println("The user doesnt exist");
				
			}
		}
		return false;
		
	}
}
