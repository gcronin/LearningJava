import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;


public class move10cm{
	public static void main(String[] args) { 
		 LCD.drawString("Press Button", 0, 0);
		 Button.waitForAnyPress();
		 LCD.clear();   
		 Motor.B.rotate(209, true);
		 Motor.C.rotate(209, true);
		 Button.waitForAnyPress();
		 LCD.drawInt(Motor.B.getTachoCount(),0,0);
		 LCD.drawInt(Motor.C.getTachoCount(),0,1);
		 Button.waitForAnyPress();
	
	}
} 