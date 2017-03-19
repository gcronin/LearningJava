import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;

public class roomba{
	public static void main(String[] args) { 
		TouchSensor bumper = new TouchSensor(SensorPort.S1);
		LCD.drawString("Press Button", 0, 0);
		Button.waitForAnyPress();
		while(true)
		{
			if(bumper.isPressed())
			{
				Motor.B.stop();
		 		Motor.C.stop();
			}	
			else
			{
				Motor.B.forward();
		 		Motor.C.forward();
			}
		}
	}
} 