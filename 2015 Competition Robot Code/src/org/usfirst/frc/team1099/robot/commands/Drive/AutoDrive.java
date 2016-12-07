package org.usfirst.frc.team1099.robot.commands.Drive;

import org.usfirst.frc.team1099.robot.Robot;
import org.usfirst.frc.team1099.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	
	double x, y, z;
	

    public AutoDrive(double x, double y, double z) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	
    	requires(Robot.drive);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.drive(x, y, z);
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
