import lejos.nxt.*;
import lejos.nxt.comm.*;
import lejos.robotics.navigation.*;
import java.io.*;
import local.CommandConstants;


public class Robot implements CommandConstants {
	
	
	
	public static void main(String [] args) throws Exception 
	{
		int[] _command = new int[3];
		int[] _reply = new int[8];
		boolean _keepItRunning = true;
		String _connected = "Connected";
        String _waiting = "Waiting...";
        String _closing = "Closing...";
        DataInputStream _dis = null;
        DataOutputStream _dos = null;
        BTConnection _btc = null;
        UltrasonicSensor _sonic = new UltrasonicSensor(SensorPort.S1);
        Pilot _piloting = new TachoPilot(56.0f, 121.0f, Motor.C, Motor.A);
        
        
        //for(int i = 0; i<3; i++)
        //{
        //	command[i] = 0;
        //}
		LCD.drawString(_waiting,0,0);
		LCD.refresh();
		
		Sound.twoBeeps();

		// Slave waits for Master to connect
        _btc = Bluetooth.waitForConnection();
        
		LCD.clear();
		LCD.drawString(_connected,0,0);
		LCD.refresh();	

		// Set up the data input and output streams
		_dis = _btc.openDataInputStream();
		_dos = _btc.openDataOutputStream();
		
		Sound.beepSequenceUp();
		
		while (_keepItRunning)
		{
			// Fetch the Master's command
			for(int k = 0; k<3; k++){
				_command[k] = _dis.readInt();
			}
			
			LCD.clear();
			LCD.drawInt(_command[0], 0, 0);
			LCD.drawInt(_command[1], 0, 2);
			LCD.drawInt(_command[2], 0, 4);
			LCD.refresh();
			
			// Respond to the Master's command which is stored in command[0]
						
			switch(_command[0]){
			// Get the battery voltage
			case COMMAND_BATTERY_VOLTAGE: 
					_reply[0] = Battery.getVoltageMilliVolt();
					for(int n = 1; n < 8; n++){
						_reply[n] = 0;
					}
					break;
			// Manual Ping
			case COMMAND_PING: 
					_sonic.ping();
					try{Thread.sleep(20);}
					catch(InterruptedException e){
						System.exit(0);
					}
					_sonic.getDistances(_reply);
					break;
			// Travel forward requested distance and return sonic sensor distance
			case COMMAND_TRAVEL: 
					_piloting.setMoveSpeed(_command[2]);
					_piloting.travel(_command[1]);
					//sonic.capture();
					_sonic.ping();
					try{Thread.sleep(20);}
					catch(InterruptedException e){
						System.exit(0);
					}
					_sonic.getDistances(_reply);
					break;
			// Rotate requested angle and return sonic sensor distance
			case COMMAND_TURN: 
					_piloting.setMoveSpeed(_command[2]);
					_piloting.rotate(_command[1]);
					//sonic.capture();
					_sonic.ping();
					try{Thread.sleep(20);}
					catch(InterruptedException e){
						System.exit(0);
					}
					_sonic.getDistances(_reply);
					break;
			// Master warns of a bluetooth disconnect; set while loop so it stops
			case COMMAND_DISCONNECT:	
					_keepItRunning = false;
					for(int k = 0; k < 8; k++){
						_reply[k] = 255;
					}
					break;
					
			} // End case structure
			
			// Slave send back reply
			LCD.clear();
			for(int k=0; k<8; k++){
				LCD.drawInt(_reply[k], 0, k);
			}
			LCD.refresh();
			
			
			//LCD.drawInt(reply[0],0,6);
			for(int k=0 ; k < 8 ; k++){
				_dos.writeInt(_reply[k]);
				_dos.flush();
			}

		}// End of while loop
		
		// Slave begins disconnect cycle
		
		//try{Thread.sleep(5000);}
		//catch(InterruptedException e){
		//	System.exit(0);
		//}
		
		// Close the data input and output streams
		_dis.close();
		_dos.close();
		Thread.sleep(100); // wait for data to drain
		LCD.clear();
		LCD.drawString(_closing,0,0);
		LCD.refresh();
		// Close the bluetooth connection from the Slave's point-of-view
		_btc.close();
		LCD.clear();
	}
}

