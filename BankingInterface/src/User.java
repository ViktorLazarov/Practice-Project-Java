public class User {
	private String name;
	private String password;
	private double balance = 0;

	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public void setBalance(double amount){
		this.balance = amount;
	}
	
	//getter
	public String getName() {
		return this.name;
	}
	public String getPassword() {
		return this.password;
	}
	public double getBalance() {
		return this.balance;
	}
	
}
