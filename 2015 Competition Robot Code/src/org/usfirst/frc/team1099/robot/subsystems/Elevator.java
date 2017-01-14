package org.usfirst.frc.team1099.robot.subsystems;


import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Elevator.Elevator_Stop;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Victor elevator_drive;
	DigitalInput uplimit;
	DigitalInput downlimit;
	Encoder encoder;
	
	public Elevator() {
		elevator_drive = new Victor(4);
		uplimit = new DigitalInput(RobotMap.UPLIMIT);
		downlimit = new DigitalInput(RobotMap.DOWNLIMIT);
		//elevator_drive.changeControlMode(ControlMode.PercentVbus);
		
		encoder = new Encoder( RobotMap.ENCODER_A, RobotMap.ENCODER_B);
		encoder.setReverseDirection( true );
		encoder.reset();
	}
	
	public void up(double speed) {
		
		if( speed < 0 && uplimit() )		// going up?
			speed = 0;
		
		if( speed > 0 && downlimit() )
			speed = 0;
				
		// Since this is where all motion occurs, we can reset the encoder here
		if ( downlimit() ) encoder.reset();
		
		elevator_drive.set(speed);
		
		// and let's throw some output here
		SmartDashboard.putBoolean("Lower Limit", downlimit());
		SmartDashboard.putBoolean("Upper Limit", uplimit());
		SmartDashboard.putNumber("Encoder", encoder.get());
		
		
	}
	
	public void moveTo( int target )
	{
		int current = getEncoderValue();
		
		int diff = current - target;
		
		if 		( diff > 1000 )	down(.5);
		else if ( diff > 100  )	down(.2);
		else if ( diff > 50 )	down(.1);
		
		if		( diff < -1000 )	up(.5);
		else if ( diff < -100  )	down(.2);
		else if ( diff < -50   )	down(.1);
		
		
	}
	
	public void down(double speed) {
		up( -speed );
	}
	
	public void stop() {
		//elevator_drive.disableControl();
		elevator_drive.set(0);
	}
	
	public boolean uplimit() {
		return !uplimit.get();
	}
	
	public boolean downlimit() {
		return !downlimit.get();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Elevator_Stop());
    }
    
    public int getEncoderValue()
    {
    	return -encoder.get();
    }
  
}

