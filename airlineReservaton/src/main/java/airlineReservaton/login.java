package airlineReservaton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class login {
	private static String userName;
	private static String password;
	public String getUserName()
	{
		return userName;
	}
	public static void setUserName(String name)
	{
		userName = name;
	}
	public static String getPassword()
	{
		return password;
	}
	public static void setPassword(String pass)
	{
		password = pass;
	}
			public static boolean loggingin() throws Exception 
			{
				//Opening file...
					File file = new File("passengers.csv");
					if(!file.exists())
					{
						try {
							file.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					//entering info...
				System.out.println("Please enter your username: ");
				Scanner input = new Scanner(System.in);
				String name = input.nextLine();
				
				
				//
				FileReader in = new FileReader ("passengers.csv");
				BufferedReader br = new BufferedReader(in);
				String line;
				br.readLine();
				int check = 0;
				int length = 79;
				while((line=br.readLine())!=null)
				{
					length += line.length();
					
					String[] split=line.split(",");
					if(split[1].equals(name))
					{
						System.out.println("Please enter your password: ");
						name = input.nextLine();
						check = 1;
						if(split[3].equals(name))
						{
							check = 2;
							setPassword(split[3]);
							setUserName(split[1]);
						}
					}
				}
				if(check == 0)
				{
					throw new InvalidUsername("Invalid Username!");
				}
				else if(check == 1)
				{
					throw new InvalidPassword("Invalid password!");
				}
				return true;
			}
			
			public static boolean signup() throws Exception 
			{
				Scanner input = new Scanner(System.in);
				File file = new File("passengers.csv");
				if(!file.exists())
				{
					try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter buffer = new BufferedWriter(fw);
				
				//Input and write name...
				System.out.println("Please enter your name: ");
				String name = input.nextLine();
				buffer.write("\n" + name); 
				
				//Input and write user-name...
				System.out.println("Please enter your user-name: ");
				name = input.nextLine();
				FileReader in = new FileReader ("passengers.csv");
				BufferedReader br = new BufferedReader(in);
				String line;
				br.readLine();
				while((line=br.readLine())!=null)
				{
					String[] split=line.split(",");
					if(split[1].equals(name))
					{
						throw new InvalidUsername("Username already taken");
					}
				}
				in.close();
				br.close();

				setUserName(name);
				buffer.write(","+name); 
				
				//Input and write email ID...
				System.out.println("Please enter your email ID: ");
				name = input.nextLine();
				
				//Email Exception...
				in = new FileReader ("passengers.csv");
				br = new BufferedReader(in);
				br.readLine();
				while((line=br.readLine())!=null)
				{
					String[] split=line.split(",");
					if(split[2].equals(name))
					{
						throw new EmailNotUnique("Email is already registered");
					}
				}
				in.close();
				br.close();
				
				buffer.write("," + name); 
				////Input and write password...
				System.out.println("Please enter your password: ");
				name = input.nextLine();
				setPassword(name);
				buffer.write(","+name); 
				buffer.close(); 
				
				
				//
				System.out.println("Your account has been successfully made!");
				return true;
			}
}

