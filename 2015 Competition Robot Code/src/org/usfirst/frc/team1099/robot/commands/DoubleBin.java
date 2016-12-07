package org.usfirst.frc.team1099.robot.commands;

import org.usfirst.frc.team1099.robot.commands.Clamp.Grab;
import org.usfirst.frc.team1099.robot.commands.Drive.AutoDrive;
import org.usfirst.frc.team1099.robot.commands.Elevator.Auto_up;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 
 
 */
public class DoubleBin extends CommandGroup {
    
	double bin_to_bin_time = 4;
	double turn_toward_zone = 3;
	double forward_to_zone = 2;
	
    public  DoubleBin() {
        
    	// maybe raise the arm a bit
    	//addSequential(new Auto_up( -0.85), .4);
    	//addSequential(new Auto_up( 0.0), .5);
    	
    	// close on the first bin
    	addSequential(new Grab(), 0.5);
    	
    	// lift as high as you can?
    	addSequential(new Auto_up( -0.8), 3.5);
    	addSequential(new Auto_up( 0.0), .1);
    	
    	// drive forward, slowly, to the next bin BIN TO BIN
    	addSequential(new AutoDrive( 0.0, -0.5, 0.0), bin_to_bin_time); 
    	
    	// drive in an ARC to the autozone
    	addSequential(new AutoDrive(0, -0.4, 0.25), turn_toward_zone);
    	
    	// forward to victory
    	addSequential(new AutoDrive( 0.0, -0.5, 0.0), forward_to_zone); 
    	
    	// 90 degress to be sure we are in the zone
    	addSequential(new AutoDrive(0,0,.75),1.2);
    }
    
    public void readValue()
    {
    	try
    	{
    		bin_to_bin_time = SmartDashboard.getNumber("auto_drive_time", bin_to_bin_time);
    		turn_toward_zone = SmartDashboard.getNumber("auto_drive_time", turn_toward_zone);
    		forward_to_zone = SmartDashboard.getNumber("auto_drive_time", forward_to_zone);
    		
    	} catch (Exception e) {
    		System.out.println( e.getMessage() );
    	}
    }
    
}
