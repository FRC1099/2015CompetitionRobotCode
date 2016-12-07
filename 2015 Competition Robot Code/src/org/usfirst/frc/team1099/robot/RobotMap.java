package org.usfirst.frc.team1099.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example, to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final double PVALUE = .1;

	//PWM Channels
	public static final int BLDRIVE = 0;
	public static final int BRDRIVE = 1;
	public static final int FLDRIVE = 2;
	public static final int FRDRIVE = 3;
	public static final int GYRO_CHANNEL = 0;
	
	//Solenoid Channels
	public static final int GRAB = 0;
	public static final int UN_GRAB = 1
			;
	
	//Joystick Ports
	public static final int STICK = 0;
	public static final int GAMEPAD = 1;
	
	//Gamepad Buttons
	public static final int CLAMPTOGGLE = 1;
	public static final int CLAMPCLOSE = 2;
	public static final int CLAMPOPEN = 3;
	public static final int LOADATOTE = 4;
	
	//Gamepad Axes
	public static final int ELEVATORUP = 3;
	public static final int ELEVATORDOWN = 2;
	
	
	//Digital Input
	public static final int UPLIMIT = 0;
	public static final int DOWNLIMIT = 1;
	public static final int ENCODER_A = 2;
	public static final int ENCODER_B = 3;

	public static final int SLOWBUTTON = 1;
	
}
