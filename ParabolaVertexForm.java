import java.util.Scanner;

public class ParabolaVertexForm {

   /* This program converts a parabola in standard form into  
    * the same parabola in vertex form.
    */
	

    public static void main(String []args) {
    	float coeffA;
    	float coeffB;
    	float coeffC;
    	double b;
    	double c;
 
      	Scanner in = new Scanner(System.in);
 
 		System.out.println("y=Ax2 + Bx + C");
      	System.out.println("Enter A");
      	coeffA = in.nextFloat();
      	System.out.println("Enter B");
      	coeffB = in.nextFloat();
      	System.out.println("Enter C");
      	coeffC = in.nextFloat();
      
      	b = -coeffB/(2*coeffA);
      	c = coeffC - coeffA * Math.pow(b, 2);
 
 		System.out.print("y=");
 		System.out.print(coeffA);
 		System.out.print("(x-");
 		System.out.print(b);
 		System.out.print(")^2+");
 		System.out.println(c);
    }
} 