package org.usfirst.frc.team1099.robot.commands.Drive;


import org.usfirst.frc.team1099.robot.OI;
import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TeleDrive extends Command {
	
	public static DriverStation ds = DriverStation.getInstance();
	
    public TeleDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// System.out.println("Gyro Value: " +Robot.drive.getGyroAngle());
    	SmartDashboard.putNumber("Match Time Remaining", ds.getMatchTime());
    	
    	Robot.drive.drive(OI.stick.getX(), OI.stick.getY(), OI.stick.getZ());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
