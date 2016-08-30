import java.io.*;

public class TestGabe
{
	public static void main(String[] args)
	{
		System.out.println("Opening File...");
		try
		{
			//Because these are static methods, we can call the class directly without
			//creating an instance of the method.  
			AddToFile.OpenFile("test.txt");
			AddToFile.WriteToFile("Is this added?");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("Couldn't write to File.");
		}
		

	}
}