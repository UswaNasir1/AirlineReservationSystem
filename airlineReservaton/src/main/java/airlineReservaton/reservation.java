package airlineReservaton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class reservation {
		
	private static String name;
	private static String gender;
	private static int age;
	private static String address;
	private static String passport_number;
	private static String destination;
	private static String type_of_plane;
	private static String date_of_flight;
	private static String time_of_flight;
	private int seats;
	private static int price = 85000;
	private static int card;
	
	
	// Getters and Setters
	public static String getName()
	{
		return name;
	}
	public void setName(String nameOfPassenger)
	{
		name = nameOfPassenger;
	}
	public static String getTime()
	{
		return time_of_flight;
	}
	public void setTime(String time)
	{
		time_of_flight = time;
	}
	
	public static String getDate()
	{
		return date_of_flight;
	}
	public void setDate(String date)
	{
		date_of_flight = date;
	}
	
	public static int getPrice()
	{
		if(getPlaneType() == "Economy")
		{
			return price;
		}
		if(getPlaneType() == "Economy Premium")
		{
			return price + 5000;
		}
		if(getPlaneType() == "Business")
		{
			return price + 12000;
		}
		if(getPlaneType() == "First Class")
		{
			return price + 20000;
		}
		return price;
	}
	
	public static String getGender()
	{
		return gender;
	}
	public void setGender(int genderP)
	{
		if(genderP == 1)
		{
			gender = "Male";
		}
		else
			gender = "Female";
	}
	public static int getAge()
	{
		return age;
	}
	public void setAge(int passengerAge)
	{
		age = passengerAge;
	}
	public static String getAddress()
	{
		return address;
	}
	public void setAddress(String addressOfPassenger)
	{
		address = addressOfPassenger;
	}
	public static String getPassportNumber()
	{
		return passport_number;
	}
	public void setPassportNumber(String string)
	{
		passport_number = string;
	}
	public static String getDestination()
	{
		return destination;
	}
	public void setDestination(int dest)
	{
		String names[] = {"Afghanistan", "Bangladesh", "Canada","China", "Denmark",
							"France","Iraq","India","Italy", "Japan","Malaysia",
							"Norway", "Oman","Qatar","Saudi Arabia", "Spain",
							"Thailand","United Arab Emirates","United Kingdom"};
		if(dest - 1  != -1)
		{
			destination = names[dest - 1];
		}
		else
			destination = "";
	}
	public static String getPlaneType()
	{
		return type_of_plane;
	}
	public void setPlaneType(int planeType)
	{
		if(planeType == 1)
		{
			type_of_plane = "Economy";
		}
		else if(planeType == 2)
		{
			type_of_plane = "Economy Premium";
		}
		else if(planeType == 3)
		{
			type_of_plane = "Business";
		}
		else if(planeType == 4)
		{
			type_of_plane = "First Class";
		}
		else
			type_of_plane = "";
	}
	public void setSeats(int seat)
	{
		seats = seat;
	}
	public int getSeats()
	{
		return seats;
	}
	public void setCardNumber(int card_no)
	{
		card = card_no;
	}
	public int getCardNumber()
	{
		return card;
	}
	
	//To input info
	public void inputInformation() throws IOException
	{
		//Asking Information...
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		System.out.println("Please enter your name: ");
		setName(input.nextLine());
		System.out.println("Please choose your gender: ");
		System.out.println("1. Male \n2. Female ");
		int check = input.nextInt();
		while(check != 1 && check != 2)
		{
			System.out.println("Choose between 1 or 2:");
			System.out.println("1. Male \n2. Female ");
			check = input.nextInt();
		}
		setGender(check);
		System.out.println("Please enter your age:");
		setAge(input.nextInt());
		System.out.println("Please enter your address: ");
		setAddress(input1.nextLine());
		//input.nextLine();
		
		//Asking for destination...
		check = countries();
		setDestination(check);
		
		//Searching flights...
		try {
			searchFlight.findFlight(destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Passport number...
		System.out.println("Please enter your passport number: ");
		setPassportNumber(input1.nextLine());
		
		//Continuing input...
		System.out.println("Please choose the type of ticket: ");
		System.out.println("1. Economy (Rs.85,000) \n2. Premium Economy (Rs. 90,000) \n3. Business (Rs. 97,000) \n4. First Class (Rs. 1,05,000)");
		check = input.nextInt();
		while(check != 1 && check != 2 && check != 3 && check != 4)
		{
			System.out.println("Choose between 1 - 4:");
			System.out.println("1. Economy (Rs.85,000)\n2. Premium Economy (Rs. 90,000)\n3. Business (Rs. 97,000)\n4. First Class (Rs. 1,05,000)");
			check = input.nextInt();
		}
		setPlaneType(check);	
		System.out.println("Please add your credit card number: ");
		setCardNumber(input.nextInt());
		
		System.out.println("\n------------------------------------------");
		System.out.println("Your ticket has been successfully booked! ");
		System.out.println("-------------------------------------------");
		printTicket();
		cancellation cancel = new cancellation();
		
		System.out.println("\n\n-------------------------------------------");
		System.out.println(		"Press 1 if you want to cancel your booking");
		System.out.println(		"Press 2 if you want print your ticket");
		System.out.println(		"Press 3 if you want to log out");
		int option = input.nextInt();
		while(option != 3 && option != 1 && option != 2)
		{
			System.out.println("Please choose between 1 - 3: ");
			option = input.nextInt();	
		}
		if(option == 1)
		{
			cancel.cancelUpdate();
		}
		else if(option == 2)
		{
			printTicket();
		}
		else
			System.exit(0);
	}
	      
	      
	      
	      
	/*      FileReader in = new FileReader ("passengers.csv");
			BufferedReader br = new BufferedReader(in);
			String line;
			br.readLine();
			check = 0;
			int length = 32;
		    while((line=br.readLine())!=null)
			{
				length += line.length();
		
				String[] split=line.split(",");
				if(split[1].equals(log.getUserName()))
				{
					if(split[3].equals(log.getPassword()))
					{
						String newLine = content.substring(0, length) + "Abhishek" + content.substring(length);
						FileWriter writer = new FileWriter("passengers.csv");
						writer.write(newLine);
					}
				}
			}

		}
	*/
	      //FileWriter writer = new FileWriter("passengers.csv");
	      //writer.write(updatedStr);
	      //writer.close();
	
	public static void printTicket()
	{
		//reservation reserve = new reservation();
		
		System.out.println("\n\n****Welcome to International Airline****");
		System.out.println("*****************************************");
		System.out.println("------------------Ticket-----------------");
		System.out.println("*****************************************");
		System.out.println("Name of passenger: " + getName() );
		System.out.println("Gender: " + getGender());
		System.out.println("Age: " + getAge());
		System.out.println("Address: " + getAddress());
		System.out.println("Passport Number: " + getPassportNumber());
		System.out.println("Destination: " + getDestination());
		System.out.println("Class: " + getPlaneType());
		System.out.println("Date of flight: " + getDate());
		System.out.println("Time of flight: " + getTime());
		System.out.println("*****************************************\n\n");
		 
	}
	public int countries()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("List of countries where we can provide flights:");
		System.out.println("1.Afghanistan			2.Bangladesh			3.Canada ");
		System.out.println("4.China				5.Denmark			6.France");
		System.out.println("7.Iraq				8.India				9.Italy ");
		System.out.println("10.Japan			11.Malaysia			12.Norway ");
		System.out.println("13.Oman				14.Qatar			15.Saudi Arabia ");
		System.out.println("16.Spain			17.Thailand			18.United Arab Emirates ");
		System.out.println("19.United Kingdom");
		
		System.out.println("Please choose between 1 - 19");
		int check = input.nextInt();
		while(check < 1 && check > 19)
		{
			System.out.println("Choose between 1 - 19:");
			check = input.nextInt();
		}
		return check;
	}
	
	
	
}