import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class motorTest{
	public static void main(String[] args) { 
		LCD.drawString("Press Button", 0, 0);
		Button.waitForAnyPress();
		Motor.B.setSpeed(720);
		Motor.C.setSpeed(720);
		while(true) {
			Motor.B.forward();
			Motor.C.forward();
		}
	}
} 