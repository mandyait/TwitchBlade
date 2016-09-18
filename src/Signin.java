import java.util.Scanner;

public class Signin {
	
	Scanner scan = new Scanner(System.in);

	String username;
	String password;
	void register()
	{
		System.out.println("enter the username");
		username = scan.nextLine();
		System.out.println("enter the password");
		password = scan.nextLine();
	}
	
}
