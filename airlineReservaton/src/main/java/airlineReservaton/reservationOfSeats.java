package airlineReservaton;
import java.util.*;
import java.io.*;

public class reservationOfSeats {
	public static void display() throws IOException
	{
		int option;
		System.out.println("\n--------------------------------------------");
		System.out.println("---------Airline Reservation System---------");
		System.out.println("--------------------------------------------");
		System.out.println("\nOptions:");
		System.out.println("1. Login");
		System.out.println("2. Signup");
		System.out.println("Please choose between 1 - 2:");
		Scanner input = new Scanner(System.in);
		option = input.nextInt();
		login in = new login();
		boolean flag = false;
		if(option == 1)
		{
			try {
				flag = in.loggingin();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		else if(option == 2)
		{
			try {
				flag = in.signup();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		if(flag == true)
		{
				option = 0;
				while(option != 3)
				{
				System.out.println("\n----------------- Options: -----------------");
				System.out.println("1. Reservation");
				System.out.println("2. Check avaialable flights");
				System.out.println("3. Exit");
				System.out.println("Choose between 1-3:");
				option = input.nextInt();
				if(option == 1)
				{
					reservation reserve = new  reservation();
					reserve.inputInformation();
				}
				else if(option == 2)
				{
					reservation reserve = new reservation();
					int country = reserve.countries();
					
					String names[] = {"Afghanistan", "Bangladesh", "Canada","China", "Denmark",
							"France","Iraq","India","Italy", "Japan","Malaysia",
							"Norway", "Oman","Qatar","Saudi Arabia", "Spain",
							"Thailand","United Arab Emirates","United Kingdom"};
		
					String destination = names[country - 1];
					
					searchFlight search = new searchFlight();
					search.findFlight(destination);
				}
				else if (option == 3)
				{
					System.exit(0);
				}
			}
		}	
	}
	public static void main (String args[]) throws IOException
	{
		display();	
	}
}
