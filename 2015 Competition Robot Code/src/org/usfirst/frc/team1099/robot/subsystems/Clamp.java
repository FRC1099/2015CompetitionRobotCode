package org.usfirst.frc.team1099.robot.subsystems;

import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Clamp extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid grab = new DoubleSolenoid(RobotMap.GRAB,RobotMap.UN_GRAB);
	
	private boolean bOpen = true;
	
	public Clamp() {
		
	}
	
	public void grab() {
		grab.set(DoubleSolenoid.Value.kForward);
		bOpen = false;
	}
	
	public void un_grab() {
		grab.set(DoubleSolenoid.Value.kReverse);
		bOpen = true;
	}
	
	public boolean isOpen() {
		return bOpen;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

