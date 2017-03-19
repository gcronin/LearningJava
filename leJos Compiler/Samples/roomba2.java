import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;

public class roomba2{
	public static void main(String[] args) { 
		TouchSensor bumper = new TouchSensor(SensorPort.S1);
		LCD.drawString("Press Button", 0, 0);
		Button.waitForAnyPress();
		while(true)
		{
			if(bumper.isPressed())
			{
				Motor.B.rotate(-209, true);
		 		Motor.C.rotate(-209);
		 		Motor.B.rotate(-125, true);
		 		Motor.C.rotate(125);

			}	
			else
			{
				Motor.B.forward();
		 		Motor.C.forward();
			}
		}
	}
} 