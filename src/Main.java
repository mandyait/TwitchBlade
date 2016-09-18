import java.util.Scanner;

public class Main{
	
	public static void signin() 
	{

		Scanner scan = new Scanner(System.in);
		int username_length;
		int password_length;
		System.out.println("enter the username");
		String username = scan.nextLine();
		System.out.println("enter the password");
		String password = scan.nextLine();
		username_length=username.length();
		password_length=password.length();
		if(username.length()<=5) {
				System.out.println("your username length should be more than 5 ");
				intro();
		}

	  if(password.length()<=5) {
				System.out.println("password lenth should be greater than 5");
				intro();
	  }
		System.exit(0);
	}
	private static void tweet() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("WRITE TWEET");
		
	
	}
	public static void intro() {

      Scanner scan = new Scanner(System.in);

      System.out.println("TWITCHBLADE: ");
    	System.out.println("1.write tweet");
      System.out.println("2.Sign up ");
      System.out.println("3. Sign ip ");
      System.out.println("4. timeline ");
      System.out.println("5. logout");
      System.out.println("ENTER YOUR CHOICE : ");
      int i=scan.nextInt();

    switch(i) {
        case 1:
        {
        	System.out.println("");
        }
        break;
        case 2:
        {
        	System.out.println("enter signup details");
        	signin();
        }
        break;
    }
}
	public static void main(String[] args) {
			Main m= new Main();
			m.intro();
  }
}
