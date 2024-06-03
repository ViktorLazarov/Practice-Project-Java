public class User {
	private String name;
	private String password;
	private double balance;
	
	// constructor
	public User(String name, String password , double balance){
		this.name = name;
		this.password = password;
		this.balance = balance;
		
	}
	
	public User(String name, String password){
		this.name = name;
		this.password = password;
		
	}
	
	
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	//getter
	public String getName() {
		return this.name;
	}
	
}
