import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class PilotEnhanced extends TachoPilot {
	
	public PilotEnhanced(float wheelDiameter, float wheelBase, 
			Motor left, Motor right, boolean reversal ){
		super(wheelDiameter, wheelBase, left, right, reversal);
	}
	
	public void setWheelBase(float wheelBase){
		//_trackWidth = wheelBase;
	}

}
