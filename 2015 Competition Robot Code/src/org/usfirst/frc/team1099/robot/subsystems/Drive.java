package org.usfirst.frc.team1099.robot.subsystems;


import org.usfirst.frc.team1099.robot.RobotMap;
import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Drive.TeleDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
		RobotDrive drive = new RobotDrive(RobotMap.FLDRIVE, RobotMap.BLDRIVE, RobotMap.FRDRIVE, RobotMap.BRDRIVE);

		public Drive() {
			drive.setInvertedMotor(MotorType.kFrontRight, true);
			drive.setInvertedMotor(MotorType.kRearRight, true);
		}
		
		public void drive(double x, double y, double z, boolean fieldOriented) {
		}
		
		public void drive(double x, double y, double z) {
			drive(x,y,z,false);
		}
		
		public void resetGyro() {
		}
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TeleDrive());
    }
}

