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
public class BinTote extends CommandGroup {
    
	double  auto_drive_time = 2.0;
	
    public  BinTote() {
        
    	// read the user values from the SmartDashboard
    	readValue();
	
    	// Lift the bin
    	addSequential(new Grab(), 0.5);
    	addSequential(new Auto_up( -0.75), 1.5);
    	addSequential(new Auto_up( 0.0), 0.1);	// stop

    	// drive forward to engage tote, with just a touch of twist
    	addSequential(new AutoDrive(0.0, -0.5, -0.2), .8);
    	
    	// turn and drive toward scoring zone, mostly turn
    	addSequential(new AutoDrive( 0.0, -0.1, -0.5), 2); 
   
    	// drive forward
    	addSequential(new AutoDrive( 0.0, -0.6, 0.0), auto_drive_time); 
    	
    	// turn so we are in the zone
    	// change log: after match 45, change time from 1.2 to 1.5
    	
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
