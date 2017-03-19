import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import java.util.Random;

public class roomba3{
	public static void main(String[] args) { 
		Random rand = new Random();
		TouchSensor bumper = new TouchSensor(SensorPort.S1);
		LCD.drawString("Press Button", 0, 0);
		Button.waitForAnyPress();
		while(true)
		{
			if(bumper.isPressed())
			{
				Motor.B.rotate(-209, true);
		 		Motor.C.rotate(-209);
		 		int randomAngle = rand.nextInt(125);
		 		Motor.B.rotate(-randomAngle, true);
		 		Motor.C.rotate(randomAngle);

			}	
			else
			{
				Motor.B.forward();
		 		Motor.C.forward();
			}
		}
	}
} 