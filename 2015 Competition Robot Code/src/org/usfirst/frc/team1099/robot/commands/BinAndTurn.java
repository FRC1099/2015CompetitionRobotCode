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
public class BinAndTurn extends CommandGroup {
    
	double auto_drive_time = 3.0;
	
    public  BinAndTurn() {
        
    	// read the user values from the SmartDashboard
    	readValue();
	
    	// SmartDashboard.putNumber( "test", auto_drive_time  * 2);
    	addSequential(new Grab(), 0.5);
    	
    	addSequential(new Auto_up( -0.4), 1);
    	addSequential(new Auto_up( 0.0), .1);

    	// rotate toward drivers
    	// change log: after match 45, changed time from 1.5 to 1.2
    	addSequential(new AutoDrive(0,0,.6), 1.5);
    	
    	// backwards
    	addSequential(new AutoDrive( 0.0, 0.7, 0.0), auto_drive_time); 
   
    	// turn
    	// change log: after match 45, change time from 1.2 to 1.5
    	addSequential(new AutoDrive(0,0,-.75),1.2);
    	
    	
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
