import java.util.Scanner;
import java.sql.*;

public class Main{

	public  static void signup()
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
				System.out.println("password length should be greater than 5");
				intro();
	  }

		//database Connection
		try{
	Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitchblade","root","etc@12815");
		Statement stmt = con.createStatement();
		stmt = con.createStatement();
		String sql = "insert into users (username,password) values ('"+username+"', '"+password+"')";
	  stmt.executeUpdate(sql);
		con.close();
		}catch(Exception e){ System.out.println(e);}

		System.exit(0);
	}

	public  static void signin()
	{
			int id = 0;
		 	Scanner scan = new Scanner(System.in);
			System.out.println("SIGN IN");
			System.out.println("enter the username");
			String username = scan.nextLine();
			System.out.println("enter the password");
			String password = scan.nextLine();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitchblade","root","etc@12815");
				Statement stmt = con.createStatement();
				String username1 = "";
				String password1 = "";
				stmt = con.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("SELECT sno, username, password FROM users WHERE username = '"+username+"' and password = '"+password+"'");
            while ( rs.next() )
						{
								id = rs.getInt("sno");
                username1 = rs.getString("username");
								password1 = rs.getString("password");
            }
			if( ((username).equals(username1)) && ((password).equals(password1))	)
			{
				System.out.println("succecesfully login");
				System.out.println("1.TWEET ");
	      System.out.println("2.TIMELINE");
				System.out.println("3.SIGN OUT");
	      System.out.println("ENTER YOUR CHOICE : ");
	      int i=scan.nextInt();
				switch(i)
				{
		        case 1:
		        {
						  tweet(id);
							break;
		        }
		        case 2:
		        {
		        	timeline(id);
							break;
		        }
						default :
						{
								System.exit(0);
						}
				}
	  	}
			else
			{
				System.out.println("username or password is wrong");
				//login page
			}

				con.close();
			}catch(Exception e){ System.out.println(e);}


	}

		public static void tweet(int sno)
		{
				Scanner scan = new Scanner(System.in);
				System.out.println("WRITE TWEET");
				String tweet = scan.nextLine();
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitchblade","root","etc@12815");
					Statement stmt = con.createStatement();
					String sql = "insert into tweet(tweet,sno) values ('"+tweet+"','"+sno+"')";
					stmt.executeUpdate(sql);
					con.close();
					}catch(Exception e)
					{
						System.out.println(e);
					}
			}
			public static void timeline(int s_id)
			{
				int id=0;
				String tweet="";
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/twitchblade","root","etc@12815");
					Statement stmt = con.createStatement();
					ResultSet rs;
					rs = stmt.executeQuery("SELECT sno, tweet FROM tweet WHERE sno = '"+s_id+"'");
          while ( rs.next() )
					{
							s_id = rs.getInt("sno");
							tweet = rs.getString("tweet");
							System.out.println("id is:"+ s_id + "tweet:" +tweet);
					}
					con.close();
				}catch(Exception e)
				{
					System.out.println(e);
				}
		 }

			public static void intro()
			{
				int i = 0;
				do{
			    i = mainMenu();
				  switch(i) {
				      case 1:
				      {
				      	System.out.println("enter signin details");
							  signin();
								break;
				      }
				      case 2:
				      {
				      	System.out.println("enter signup details");
				      	signup();
								break;
				      }
							case 3:
							{
								System.exit(0);
							}
				  }
					System.out.println("please enter the correct CHOICE:");
			 }while(i > 3);
    }
		public static int mainMenu()
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("TWITCHBLADE: ");
			System.out.println("1.sign in");
			System.out.println("2.Sign up ");
			System.out.println("3.exit");
			System.out.println("ENTER YOUR CHOICE : ");
			return scan.nextInt();
		}
	public static void main(String[] args) {
			Main m= new Main();
			m.intro();
  }
}
