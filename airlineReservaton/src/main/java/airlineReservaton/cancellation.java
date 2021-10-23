package airlineReservaton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class cancellation {
	public static void cancelUpdate() throws IOException
	{
		try {
			File file = new File("flights.csv");
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(fw);
			
			FileReader fr = new FileReader("flights.csv");
		      
		    String content = new Scanner(new File("flights.csv")).useDelimiter("\\Z").next();
		    fr.close();
		    
		    reservation reserve = new reservation();
		    
		    FileReader in = new FileReader ("flights.csv");
			BufferedReader br = new BufferedReader(in);
			String line;
			br.readLine();
			int check = 0;
			int length = 57;
		    while((line=br.readLine())!=null)
			{
				length += line.length();
		
				String[] split=line.split(",");
				if(split[0].equals(reserve.getDestination()))
				{
					if(split[2].equals(reserve.getDate()))
					{
						if(split[1].equals(reserve.getTime()))
						{
							RandomAccessFile raf = new RandomAccessFile("flights.csv", "rw");
							raf.seek(length);
							int num = (Integer.valueOf(split[3]))+1;
							split[3] = Integer.toString(num);
							raf.write(split[3].getBytes());
							raf.close();
							reserve.setDestination(0);
							reserve.setPlaneType(0);
							reserve.setTime("");
							reserve.setDate("");
							System.out.println("Your flight has been cancelled!");
						}
					}
				}
			}

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
