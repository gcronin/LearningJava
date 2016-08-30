import java.util.Scanner;
import java.io.*;  //needed to deal with Exceptions

public class AddToFile
{
	//static in this context is necessary because the scanner is used by 
	//main which is also static.  So all objects in main must be static.
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.println("Enter Text to Add to File");
		String text = sc.next();
		System.out.println("You entered: "+text);
		System.out.println("Enter Filename");
		String fileName = sc.next();
		System.out.println(System.getProperty("user.dir"));
		System.out.println("You entered: "+fileName);
		
		// Both of these exceptions are mandatory to deal with.  From class FileOutputStream, 
		// main method throws FileNotFoundException, and write method throw IOException.
		try
		{
			OpenFile(fileName);
			WriteToFile(text);
			f.close();
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

	private static FileOutputStream f;

// this is a method... it is declared public so anyone can use it.  It is declared
// static so that an instance of the AddToFile object doesn't need to be created
// prior to running this method.  It throws an exception that must be caught.
	public static void OpenFile(String name) throws FileNotFoundException
	{
		f = new FileOutputStream(name, true);
	}

	public static void WriteToFile(String text) throws IOException
	{
		byte[] b = text.getBytes();
		f.write(b);
	}

}