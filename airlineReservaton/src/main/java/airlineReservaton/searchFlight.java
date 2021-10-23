package airlineReservaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class searchFlight{
	public static void findFlight(String search) throws IOException
	{
		System.out.println("Following are the flights avaliable for your desired destination: ");
		try
		{
			int index = 0;
			FileReader in = new FileReader ("flights.csv");
			BufferedReader br = new BufferedReader(in);
			String line;
			br.readLine();
			int index1 = 0;
			String[] flights = {"","","","","","",""};
			while((line = br.readLine())!=null)
			{
				String[] split=line.split(",");
				if(split[0].equals(search))
				{
					flights[index1] = line;
					index1++;
						System.out.println("-----------------------------------");
						System.out.println(index+1 + ". Destination: " + split[0]);
						System.out.println("   Date of departure: " + split[1]);
						System.out.println("   Time of departure: " + split[2]);
						System.out.println("   Available seats: " + split[3]);
						index++;
				}
			}
			System.out.println("-----------------------------------");
			System.out.println("Please choose between 1 - " + index + " : ");
			Scanner input = new Scanner(System.in);
			int num = input.nextInt();
			
			String[] reserved_info = flights[num-1].split(",");
			reservation reserve = new reservation();
			reserve.setTime(reserved_info[1]);
			reserve.setDate(reserved_info[2]);
			  try{
				  reserve.setSeats(Integer.parseInt(reserved_info[3])-1);
		        }
		        catch (NumberFormatException ex){
		            ex.printStackTrace();
		        }
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}	
	}
}
