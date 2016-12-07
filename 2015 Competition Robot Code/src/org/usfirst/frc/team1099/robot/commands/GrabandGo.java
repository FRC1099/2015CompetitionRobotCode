package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Clamp.Grab;
import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Elevator.Auto_up;
import org.usfirst.frc.team1099.robot.commands.Elevator.Elevator_Up;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GrabandGo extends CommandGroup {
    
	double auto_drive_time = 3.0;
	
    public  GrabandGo() {
	
    	readValue();
    	
    	// grab and lift
    	addSequential(new Grab(), 0.1);
    	addSequential(new Auto_up( -0.4), 1);
    	addSequential(new Auto_up( 0.0), .1);

    	// backwards
    	addSequential(new AutoDrive( 0.0, 0.7, 0.0), auto_drive_time); 
    	
    	// turn
    	addSequential(new AutoDrive(0,0,.75),1.2);
    	
    }
    
    public void readValue()
    {
    	try
    	{
    		auto_drive_time = SmartDashboard.getNumber("auto_drive_time", auto_drive_time);
    		
    	} catch (Exception e) {
    		System.out.println( e.getMessage() );
    	}
    }
    
}
