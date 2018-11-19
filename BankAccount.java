import java.util.Scanner;

public class ATM { 
	static Scanner in = new Scanner(System.in);
	private BankAccount bankaccount;
	ATM(BankAccount bankaccount){
		this.bankaccount = bankaccount;
	}
	public static void main (String[] args) {
		System.out.println("Please create an account.");
		double balance = 0.0;
		System.out.println("SSN: ");
		int ssn = in.nextInt();
		in.nextLine();
		System.out.println("Name: ");
		String name = in.nextLine();
		System.out.println("Date of Birth: ");
		String dob = in.nextLine();
		System.out.println("Address: ");
		String address = in.nextLine();

		AccountHolder user = new AccountHolder(ssn, name, dob, address);

		System.out.println("Please input a pin: ");
		int pin = in.nextInt();
		System.out.println("Account Number: ");
		int account = in.nextInt();
		
		BankAccount bankaccount = new BankAccount(user, pin, balance, account);
		ATM atm1 = new ATM(bankaccount);
		System.out.println("Account Login: ");
		if(atm1.security()){
			do{
				atm1.menu();
			}while(atm1.again());
		}
		else{
			System.out.println("Try Again");
		}
		in.close();
	}
	public boolean security() {
		System.out.println("What is your pin?");
		int userpin = in.nextInt();
		in.nextLine();
		if(userpin == this.bankaccount.pin()){
			return true;
		}
		else {
			System.out.println("Invalid Pin");
			return false;
		}
	}
	public void menu() {
		System.out.println("What would you like to do?");
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Check Balance");
		int a = in.nextInt();
		if(a == 1) {
			System.out.println("How much would you like to deposit?");
			int b = in.nextInt();
			this.bankaccount.deposit(b);
			System.out.println("Transaction Complete");
		}
		else if(a == 2) {
			System.out.println("How much would you like to withdraw?");
			int b = in.nextInt();
			this.bankaccount.withdraw(b);
			System.out.println("Transaction Complete");
		}
		else if(a == 3){
			System.out.print("This is your current balance: ");
			System.out.println("$" + this.bankaccount.getBalance());
		}
		else {
			System.out.println("Incorrect input, try again.");
		}
	}
	public boolean again() {
		System.out.println("Do you want another transaction? (1 for yes/2 for no)");
		int answer = in.nextInt();
		in.nextLine();
		if(answer == 1) {
			return true;
		}
		else {
			return false;
		}
	}
}
