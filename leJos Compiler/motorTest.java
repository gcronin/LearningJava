import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.NXTMotor;
import lejos.nxt.MotorPort;

public class motorTest{
	public static void main(String[] args) { 
		NXTMotor mB = new NXTMotor(MotorPort.B);
		NXTMotor mC = new NXTMotor(MotorPort.C);
		while(true) {
			mB.setPower(50);
			mC.setPower(50);
		}
	}
} 