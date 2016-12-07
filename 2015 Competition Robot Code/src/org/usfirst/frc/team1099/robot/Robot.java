
package org.usfirst.frc.team1099.robot;


import org.usfirst.frc.team1099.robot.commands.BinAndTurn;
import org.usfirst.frc.team1099.robot.commands.BinTote;
import org.usfirst.frc.team1099.robot.commands.DoNothing;
import org.usfirst.frc.team1099.robot.commands.DoubleBin;
import org.usfirst.frc.team1099.robot.commands.DriveAuto;
import org.usfirst.frc.team1099.robot.commands.GrabandGo;
import org.usfirst.frc.team1099.robot.subsystems.Clamp;
import org.usfirst.frc.team1099.robot.subsystems.Drive;
import org.usfirst.frc.team1099.robot.subsystems.Elevator;







import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final Drive drive = new Drive();
	public static final Elevator elevator = new Elevator();
	public static final Clamp clamp = new Clamp();
	public static OI oi;
    Command autonomousCommand;
    SendableChooser autoChooser;   
    //CameraServer server;
     
     public Robot() {
     }
     
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		// Not sure if we need this anymore, but "just in case"
		SmartDashboard.putNumber( "auto_drive_time", 2.2 );
		SmartDashboard.putNumber("bin_to_bin_time", 4);
		SmartDashboard.putNumber("turn_toward_zone", 3);
		SmartDashboard.putNumber("forward_to_zone", 2);
			
		// set up the chooser here
        autoChooser = new SendableChooser();
        autoChooser.addDefault( "Tote: Twist-Backup-Twist", new DriveAuto() );
        autoChooser.addObject( "Bin: Just Back it up", new GrabandGo() );
        autoChooser.addObject("Bin: Bin and Turn", new BinAndTurn());
        autoChooser.addObject("Bin: Drive thru two bins", new DoubleBin());
        autoChooser.addObject("Tote + Bin: Grab/lift/drive through tote", new BinTote() );
        autoChooser.addObject("Do Nothing", new DoNothing() );
        
        SmartDashboard.putData( "Auto Mode: ", autoChooser );
        

        
    }
	
    public void autonomousInit() {
        
    	// instantiate the command used for the autonomous period                
        autonomousCommand = (Command) autoChooser.getSelected();
    	
        if( autonomousCommand instanceof DriveAuto )
        {
        	DriveAuto myCommand = (DriveAuto) autonomousCommand;
        	myCommand.readValue();
        }
        
        if (autonomousCommand instanceof GrabandGo) {
        	GrabandGo myCommand = (GrabandGo) autonomousCommand;
        	myCommand.readValue();
        }
        
        if (autonomousCommand instanceof BinAndTurn) {
        	BinAndTurn myCommand = (BinAndTurn) autonomousCommand;
        	myCommand.readValue();
        }
        
        if (autonomousCommand instanceof DoubleBin) {
        	DoubleBin myCommand = (DoubleBin) autonomousCommand;
        	myCommand.readValue();
        }
        
        if (autonomousCommand instanceof BinTote) {
        	BinTote myCommand = (BinTote) autonomousCommand;
        	myCommand.readValue();
        }
        
       
        autonomousCommand.start();
    }
    
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		
	}

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
 }
