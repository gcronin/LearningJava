import java.util.Scanner;

public class DistanceFormula {

   /* This is my first java program.  
    * This will print 'Hello World' as the output
    */
	

    public static void main(String []args) {
    	float x1;
    	float y1;
    	float x2;
    	float y2;
 
      	Scanner in = new Scanner(System.in);
 
      	System.out.println("Enter x1");
      	x1 = in.nextFloat();
      	System.out.println("Enter y1");
      	y1 = in.nextFloat();
      	System.out.println("Enter x2");
      	x2 = in.nextFloat();
      	System.out.println("Enter y2");
      	y2 = in.nextFloat();
 
 		double distance = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
      
      	System.out.println(distance);
    }
} 