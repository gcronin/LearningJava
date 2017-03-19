import lejos.nxt.Button;
import lejos.nxt.LCD;
import java.util.Random;
import lejos.util.Delay;

public class displayRandom{
	public static void main(String[] args) { 
		Random rand = new Random();
		LCD.drawString("Press Button", 0, 0);
		Button.waitForAnyPress();
		while(true)
		{
			int randomNum = rand.nextInt(60);
			LCD.clear();   
			LCD.drawInt(randomNum,0,0);
			Delay.msDelay(1000);

		}

	}
}