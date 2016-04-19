import java.io.*;
import java.util.*;

public class carTest
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br;
		try{
            br = new BufferedReader (new FileReader("Stoplight.txt"));

			String line = "";
			String prevLine = "";

			while ((line = br.readLine()) != null && prevLine != null)
			{	
				if (line.contains("green"))
				{
					if (prevLine.contains("red") || prevLine.equals(""))
					{
						System.out.println("Good");
					}
					else {
						System.out.println("The previous state should be red");
						break;
					}
				}

				else if (line.contains("yellow"))
				{
					if (prevLine.contains("green"))
					{
						System.out.println("Good");
						
					}
					else {
						System.out.println("The previous state should be green");
						break;
					}
				}

				else if (line.contains("red"))
				{
					if (prevLine.contains("yellow"))
					{
						System.out.println("Good");
					}
					else if(prevLine.contains("fault"))
					{
						System.out.println("Good");
					}	

					else {
						System.out.println("The previous state should be yellow, if not fault");
						break;
					}
				}

				else //line == fault
				{ 
					System.out.println("FAULT");
					System.out.println(line);
					System.out.println(prevLine);
				}

				prevLine = line;
			}
		}catch (IOException e){
            System.out.println("Exception");
        }
	}
}